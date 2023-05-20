package com.aninfo.model;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountCbu;

    private Double balance;

    public Account(){
    }

    public Account(Double balance) {
        this.balance = balance;
    }

    public Long getCbu() {
        return accountCbu;
    }

    public void setCbu(Long cbu) {
        this.accountCbu = cbu;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
