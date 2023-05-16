package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    private Double sum;

    private Long accountCbu;

    public Transaction(){
    }

    public Transaction(Double sum, Long accountCbu) {

        this.sum = sum;
        this.accountCbu = accountCbu;
    }

    public Long getAccountCbu() { return accountCbu; }

    public void setAccountCbu(Long accountCbu) {
        this.accountCbu = accountCbu;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getTransactionId(){ return transactionId; };

    public void setTransactionId(Long transactionId){ this.transactionId = transactionId; }

}
