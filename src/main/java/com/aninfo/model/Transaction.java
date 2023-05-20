package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    private Double sum;

    @ManyToOne
    private Account account;

    public Transaction(){
    }

    public Transaction(Double sum, Account account) {
        this.sum = sum;
        this.account = account;
    }

    public Account getAccount() { return account; }

    public Long getAccountCbu() { return account.getCbu(); }

    public void setAccount(Account account) { this.account = account; }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getTransactionId(){ return transactionId; };

    public void setTransactionId(Long transactionId){ this.transactionId = transactionId; }

}
