package com.iljaust.hibirnate.controller;

import com.iljaust.hibirnate.model.Account;
import com.iljaust.hibirnate.service.AccountService;

import java.util.List;

public class AccountController {

    private AccountService accountService = new AccountService();

    public List<Account> getAll(){

        return accountService.getAll();
    }

    public Account getById(Long id) {

        return accountService.getById(id);
    }

    public Account save(Account account) {

        return accountService.save(account);
    }

    public Account update(Account account) {

        return accountService.update(account);
    }

    public void deleteById(Long id) {

        accountService.deleteById(id);
    }

}
