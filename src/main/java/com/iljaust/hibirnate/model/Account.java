package com.iljaust.hibirnate.model;

import javax.persistence.*;
@Entity
@Table( name = "accounts")
public class Account {
    @Id
    @Column(name = "idaccounts_table")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data")
    private String data;
    @Column(name = "idaccount_status")
    private AccountStatus accountStatus;

    public Account(Long id, String data, AccountStatus accountStatus){
        this.id = id;
        this.data = data;
        this.accountStatus = accountStatus;
    }

    public Account(){

    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getData() {

        return data;
    }

    public void setData(String data) {

        this.data = data;
    }

    public AccountStatus getAccountStatus() {

        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {

        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
