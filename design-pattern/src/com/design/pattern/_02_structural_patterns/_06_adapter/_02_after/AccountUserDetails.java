package com.design.pattern._02_structural_patterns._06_adapter._02_after;


import com.design.pattern._02_structural_patterns._06_adapter._02_after.security.UserDetails;

public class AccountUserDetails implements UserDetails {
    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return this.account.getName();
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }
}
