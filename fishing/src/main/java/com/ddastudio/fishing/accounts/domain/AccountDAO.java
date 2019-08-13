package com.ddastudio.fishing.accounts.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.ddastudio.fishing.common.Constants.USE;

@Repository
@RequiredArgsConstructor
public class AccountDAO {

    private final JPAQueryFactory query;

    private static final QAccount ACCOUNT = QAccount.account;

    public Optional<AccountDTO> getAccountByPhoneNo(String phoneNo) {
        return this.getAccountByPhoneNo(AccountDTO.builder().phoneNo(phoneNo).build());
    }

    public Optional<AccountDTO> getAccountByPhoneNo(AccountDTO accountDTO) {
        AccountDTO selectAccountDTO = query.select(Projections.constructor(AccountDTO.class))
                .from(ACCOUNT)
                .where(ACCOUNT.phoneNo.eq(accountDTO.getPhoneNo())
                    .and(ACCOUNT.audit.useYn.eq(USE)))
                .fetchOne();
        return Optional.ofNullable(selectAccountDTO);

    }

    public Optional<AccountDTO> getAccountById(Integer id) {
        AccountDTO selectAccountDTO = query.select(Projections.constructor(AccountDTO.class))
                .from(ACCOUNT)
                .where(ACCOUNT.id.eq(id)
                        .and(ACCOUNT.audit.useYn.eq(USE)))
                .fetchOne();
        return Optional.ofNullable(selectAccountDTO);
    }


}
