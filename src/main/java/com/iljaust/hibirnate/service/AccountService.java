package com.iljaust.hibirnate.service;


import java.util.List;

import com.iljaust.hibirnate.model.Account;
import com.iljaust.hibirnate.repository.AccountRepository;
import com.iljaust.hibirnate.repository.AccountRepositoryImpl;



public class AccountService {

    private AccountRepository accountRepository = new AccountRepositoryImpl();


    public AccountService(){
    }

    public List<Account> getAll(){

        return accountRepository.getAll();


    }

    public Account update(Account account) {

        return accountRepository.update(account);

    }

    public void deleteById(Long id) {

        accountRepository.deleteById(id);

    }

    public Account save(Account account) {

        accountRepository.save(account);
        return account;

    }

    public Account getById(Long id) {

        return accountRepository.getById(id);

    }
}
