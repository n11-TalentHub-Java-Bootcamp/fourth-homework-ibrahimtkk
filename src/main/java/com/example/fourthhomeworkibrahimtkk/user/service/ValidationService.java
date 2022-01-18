package com.example.fourthhomeworkibrahimtkk.user.service;

import com.example.fourthhomeworkibrahimtkk.generator.validation.ValidationResult;
import com.example.fourthhomeworkibrahimtkk.user.dto.request.UserSaveRequest;

import static com.example.fourthhomeworkibrahimtkk.generator.validation.ErrorCode.*;

public class ValidationService implements com.example.fourthhomeworkibrahimtkk.generator.validation.ValidationService<UserSaveRequest> {


    @Override
    public ValidationResult validate(UserSaveRequest request) {
        if (request.getUsername() == null) {
            return ValidationResult.error("Username is null", USERNAMENOTVALID);
        }

        if (request.getName() == null) {
            return ValidationResult.error("Name of user is null", NAMENOTVALID);
        }

        if (request.getPassword() == null) {
            return ValidationResult.error("Password of user is null", PASSWORDNOTVALID);
        }

        return ValidationResult.success();
    }

}
