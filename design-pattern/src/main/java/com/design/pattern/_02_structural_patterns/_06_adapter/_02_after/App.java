package com.design.pattern._02_structural_patterns._06_adapter._02_after;

import com.design.pattern._02_structural_patterns._06_adapter._02_after.security.LoginHandler;
import com.design.pattern._02_structural_patterns._06_adapter._02_after.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("mho", "1234");
        System.out.println(login);
    }
}
