package com.ddastudio.fishing.accounts.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Integer id;
    private String phoneNo;
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
    private String accessToken;
    private String refreshToken;
    private String tokenExpiredDate;
    private String smsPublishDateTime;
}
