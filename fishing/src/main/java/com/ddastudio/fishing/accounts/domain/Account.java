package com.ddastudio.fishing.accounts.domain;

import com.ddastudio.fishing.common.audit.Audit;
import com.ddastudio.fishing.common.audit.AuditListener;
import com.ddastudio.fishing.common.audit.Auditable;
import com.ddastudio.fishing.exception.FishingValidationException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Auditable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String phoneNo;
    @NotNull
    private Integer appId;
    private String name;
    private String avatar;
    private String role;
    private String captainYn;
    private String provider;
    private String providerUid;
    private LocalDate cancelDate;
    private String email;
    private String pw;
    private String emailCheck;
    private String accountStatus;
    private String smsVerifyNo;
    private LocalDateTime smsPublishDateTime;


    @Embedded
    private Audit audit;

    public void confirm(String password) {
        this.setAccountStatus("NML");
        this.setPw(password);
    }

    public void validateSmsCode(String code) throws FishingValidationException {
        if(this.accountStatus.equalsIgnoreCase("NML"))
            throw new FishingValidationException("이미 인증되었습니다. 다시 인증하려면 인증버튼을 눌러 주세요!!");

        if(!this.smsVerifyNo.equalsIgnoreCase(code))
            throw new FishingValidationException("인증번호가 일치하지 않습니다. !!");


        if(this.smsPublishDateTime.plusMinutes(3).isBefore(LocalDateTime.now())) {
            throw new FishingValidationException("인증 시간이 만료 되었습니다. 재인증 부탁드립니다.");
        }
    }

}
