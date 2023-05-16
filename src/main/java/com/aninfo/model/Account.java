package com.aninfo.model;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cbu;

    private Double balance;

    public Account(){
    }

    public Account(Double balance) {
        this.balance = balance;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void getAffectedByTransaction(Transaction transaction) {
        this.setBalance(this.getBalance() + transaction.getSum());
    }

}
