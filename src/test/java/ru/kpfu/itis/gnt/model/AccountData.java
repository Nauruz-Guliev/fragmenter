package ru.kpfu.itis.gnt.model;

import java.util.Objects;

public class AccountData {

    private String password;
    private String email;

    private String accountCode;

    public AccountData(String password, String email, String accountCode) {
        this.password = password;
        this.email = email;
        this.accountCode = accountCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", accountCode='" + accountCode + '\'' +
                '}';
    }
}
