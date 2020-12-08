package com.iljaust.hibirnate.view;

import com.iljaust.hibirnate.model.Account;
import com.iljaust.hibirnate.model.AccountStatus;
import com.iljaust.hibirnate.controller.AccountController;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private final AccountController controller = new AccountController();
    private final Scanner scan = new Scanner(System.in);

    private AccountStatus checkStatus(Integer num){
        AccountStatus accStatus;
        switch (num){
            case 0: accStatus = AccountStatus.ACTIVE;
                break;
            case 1: accStatus = AccountStatus.DELETED;
                break;
            default: accStatus = AccountStatus.BANNED;
        }
        return accStatus;
    }

    public void deleteByIdAcc(){
        Long inputID = scan.nextLong();
        controller.deleteById(inputID);
    }

    public void saveAcc(){
        String accountData = scan.nextLine();
        Integer accStatus = scan.nextInt();
        AccountStatus accountStatus = checkStatus(accStatus);
        Account account = new Account(null,accountData,accountStatus);
        controller.save(account);
    }

    public void getByIdAcc(){
        Long inputID = scan.nextLong();
        Account account = controller.getById(inputID);
        System.out.println(account);
    }

    public void updateAcc(){
        long id = scan.nextLong();
        String accountData = scan.nextLine();
        Integer accStatus = scan.nextInt();
        AccountStatus accountStatus = checkStatus(accStatus);

        controller.update(new Account(id,accountData,accountStatus));
    }

    public void getAllAccounts(){
        List<Account> accounts = controller.getAll();

        accounts.forEach(System.out::println);
    }
}

