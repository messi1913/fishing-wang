package com.ddastudio.fishing.accounts.controller;

import com.ddastudio.fishing.accounts.domain.AccountDTO;
import com.ddastudio.fishing.accounts.domain.AccountResource;
import com.ddastudio.fishing.accounts.domain.AccountValidator;
import com.ddastudio.fishing.accounts.service.AccountService;
import com.ddastudio.fishing.exception.DataNotFoundException;
import com.ddastudio.fishing.exception.FishingException;
import com.ddastudio.fishing.exception.FishingValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "api/accounts", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class AccountController {

    private final AccountService service;
    private final AccountValidator validator;

    @PostMapping
    public ResponseEntity requestSmsService(@RequestBody AccountDTO accountDTO) throws FishingValidationException {
        log.info("===== Controller : register account =====");
        validator.validateRegister(accountDTO);
        var resource = new AccountResource(this.service.requestSmsService(accountDTO));
        resource.add(linkTo(AccountController.class).withSelfRel());
        resource.add(new Link("/docs/account.html#resources-account-create").withRel("profile"));
        resource.add(linkTo(AccountController.class).withRel("confirm-account"));
        return ResponseEntity.ok(resource);
    }


    @PatchMapping("/sms")
    public ResponseEntity confirmAccount(@RequestBody AccountDTO accountDTO) throws FishingException {
        log.info("===== Controller : Confirm sms of account =====");
        validator.validateForConfirm(accountDTO);
        AccountDTO dto = this.service.confirmAccount(accountDTO);
        this.service.getOauthTokens(dto);
        var resource = new AccountResource(dto);
        resource.add(linkTo(AccountController.class).withSelfRel());
        resource.add(new Link("/docs/account.html#resources-account-confirm").withRel("profile"));
        resource.add(linkTo(AccountController.class).withRel("update-account"));
        return ResponseEntity.ok(resource);
    }

    @PatchMapping
    public ResponseEntity updateAccount(@RequestBody AccountDTO accountDTO) throws FishingException {
        log.info("===== Controller : Modify account =====");
        validator.validateForConfirm(accountDTO);
        AccountDTO updateAccount = this.service.updateAccount(accountDTO);
        var resource = new AccountResource(updateAccount);
        resource.add(linkTo(AccountController.class).withSelfRel());
        resource.add(new Link("/docs/account.html#resources-account-update").withRel("profile"));
        resource.add(linkTo(AccountController.class).withRel("get-account"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Integer id) {
        Optional<AccountDTO> accountDTOOptional = this.service.retrieveAccount(id);
        if(accountDTOOptional.isEmpty())
            return ResponseEntity.badRequest().body("This id ["+id+"] of Account does not exist!! ");

        var resource = new AccountResource(accountDTOOptional.get());
        resource.add(linkTo(AccountController.class).withSelfRel());
        resource.add(new Link("/docs/account.html#resources-account-get").withRel("profile"));
        resource.add(linkTo(AccountController.class).withRel("update-account"));
        return ResponseEntity.ok(resource);

    }


    @PostMapping("/token")
    public ResponseEntity refreshToken(@RequestBody AccountDTO accountDTO) throws FishingValidationException, DataNotFoundException {
        log.info("===== Controller : refresh token for account =====");
        AccountDTO refreshAccountDTO = this.service.refreshOauthToken(accountDTO);

        var resource = new AccountResource(refreshAccountDTO);
        resource.add(linkTo(AccountController.class).withSelfRel());
        resource.add(new Link("/docs/account.html#resources-account-refreshToken").withRel("profile"));
        resource.add(linkTo(AccountController.class).withRel("get-account"));
        return ResponseEntity.ok(resource);
    }



}
