package com.example.fourthhomeworkibrahimtkk.generator.validation;

public enum ErrorCode {

    USERNAMENOTVALID("US1000"),
    NAMENOTVALID("US1001"),
    PASSWORDNOTVALID("US1002");

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
