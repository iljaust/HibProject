package com.iljaust.hibirnate.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @Column(name = "developers_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Skill> skillSet;
    @OneToOne
    @JoinColumn(name = "account_id",referencedColumnName = "idaccounts_table")
    private Account account;

    public Developer() {
    }

    public Developer(String name, Long id,List<Skill> skillSet, Account account){
        this.name = name;
        this.id = id;
        this.skillSet = skillSet;
        this.account = account;
    }

    public Developer(String name, Long id){
        this.name = name;
        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Skill> getSkillSet() {

        return skillSet;
    }

    public void setSkillSet(List<Skill> skillSet) {

        this.skillSet = skillSet;
    }

    public Account getAccountStatus() {

        return account;
    }

    public void setAccountStatus(Account account) {

        this.account = account;
    }


    @Override
    public String toString() {
        return "Developer : \n" +
                "id=" + id +
                ", \nname='" + name + '\'' +
                ", \nskillSet=" + skillSet +
                ", \naccountStatus=" + account +
                ' ';
    }

}
