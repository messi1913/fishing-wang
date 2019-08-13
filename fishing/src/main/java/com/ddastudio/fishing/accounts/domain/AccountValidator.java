package com.ddastudio.fishing.accounts.domain;

import com.ddastudio.fishing.exception.FishingValidationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountValidator {

    public void validateRegister(AccountDTO accountDTO) throws FishingValidationException {
        if (Objects.isNull(accountDTO.getAppId()))
            throw new FishingValidationException("App id is empty!!");


        if (Objects.isNull(accountDTO.getPhoneNo()))
            throw new FishingValidationException("Phone number is empty!!");
    }

    public void validateForConfirm(AccountDTO accountDTO) throws FishingValidationException {
        if(Objects.isNull(accountDTO.getId()))
            throw new FishingValidationException("User id is empty!!");
    }
}