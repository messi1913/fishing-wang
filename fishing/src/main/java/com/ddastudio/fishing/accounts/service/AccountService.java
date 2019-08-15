package com.ddastudio.fishing.accounts.service;

import com.ddastudio.fishing.accounts.domain.*;
import com.ddastudio.fishing.common.util.CommonUtil;
import com.ddastudio.fishing.common.util.SMSService;
import com.ddastudio.fishing.exception.DataNotFoundException;
import com.ddastudio.fishing.exception.FishingValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.ddastudio.fishing.common.Constants.USE;


@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService implements UserDetailsService {

    private final AccountDAO accountDAO;
    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final SMSService smsService;

    /**
     * Spring Security 를 이요한 사용자 조회 인증
     *
     * @param username 사용자 이름
     * @return UserDetails 사용자 인증 객체
     * @throws UsernameNotFoundException 사용자 조회 오류
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountDTO accountDTO = accountDAO.getAccountByPhoneNo(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new AccountAdapter(accountDTO);
    }

    @Transactional
    public AccountDTO requestSmsService(AccountDTO accountDTO) {
        log.info("==== Register Account ====");
        Account account = this.accountRepository.findByPhoneNoAndAuditUseYn(accountDTO.getPhoneNo(), USE)
                .orElseGet(() -> this.accountRepository.save(modelMapper.map(accountDTO, Account.class)));
        String sms;
        if (CommonUtil.getProperty("sms.test.use", "N").equals("Y")) {
            sms = "123456";
        } else {
            sms = this.smsService.sendSMS(account.getPhoneNo());
        }
        account.setSmsVerifyNo(sms);
        account.setAccountStatus("REQ");
        LocalDateTime now = LocalDateTime.now();
        account.setSmsPublishDateTime(now);
        return modelMapper.map(account, AccountDTO.class);
    }

    @Transactional
    public AccountDTO confirmAccount(AccountDTO accountDTO) throws FishingValidationException {
        log.info("==== confirm Account ====");
        Account account = this.accountRepository.findById(accountDTO.getId()).orElseThrow(() -> new UsernameNotFoundException(String.valueOf(accountDTO.getId())));
        account.validateSmsCode(accountDTO.getSmsVerifyNo());
        String password = passwordEncoder.encode(accountDTO.getSmsVerifyNo());
        account.confirm(password);
        account = this.accountRepository.save(account);
        return modelMapper.map(account, AccountDTO.class);
    }

    @Transactional
    public AccountDTO updateAccount(AccountDTO accountDTO) throws DataNotFoundException {
        Optional<Account> accountById = accountRepository.findById(accountDTO.getId());
        if (accountById.isEmpty()) {
            throw new DataNotFoundException("해당 사용자 "+accountDTO.getId()+ "는 미가입된 사용자 입니다.");
        }
        Account account = accountById.get();
        modelMapper.map(accountDTO, account);
        return accountDTO;
    }

    public Optional<AccountDTO> retrieveAccount(Integer id) {
        return accountDAO.getAccountById(id);
    }
    @Transactional
    public AccountDTO refreshOauthToken(AccountDTO accountDTO) throws DataNotFoundException, FishingValidationException {
        Optional<Account> accountById = accountRepository.findById(accountDTO.getId());
        if (accountById.isEmpty()) {
            throw new DataNotFoundException("해당 사용자 "+accountDTO.getId()+ "는 미가입된 사용자 입니다.");
        }
        AccountDTO syncAccountDTO = modelMapper.map(accountById.get(), AccountDTO.class);
        this.getOauthTokens(syncAccountDTO);
        return syncAccountDTO;
    }

    public void getOauthTokens(AccountDTO accountDTO) throws FishingValidationException {
        Map<String, Object> oauthToken = CommonUtil.requestOauth(accountDTO.getPhoneNo(), accountDTO.getSmsVerifyNo());
        String accessToken = String.valueOf(oauthToken.get("access_token"));
        if (Objects.isNull(accessToken))
            throw new FishingValidationException("Access token 발급 실패!!!");


        String refreshToken = String.valueOf(oauthToken.get("refresh_token"));
        if (Objects.isNull(refreshToken))
            throw new FishingValidationException("Refresh token 발급 실패!!!");

        int expireSeconds = (int) oauthToken.get("expires_in") + 1;

        String expiredDate = LocalDateTime.now().plusSeconds(expireSeconds).format(DateTimeFormatter.BASIC_ISO_DATE);

        accountDTO.setTokenExpiredDate(expiredDate);
        accountDTO.setAccessToken(accessToken);
        accountDTO.setRefreshToken(refreshToken);
    }
}
