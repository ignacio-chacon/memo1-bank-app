package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.AccountRepository;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long cbu) {
        return accountRepository.findById(cbu);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void deleteById(Long cbu) {
        accountRepository.deleteById(cbu);
    }

    @Transactional
    public Account withdraw(Long cbu, Double sum) {
        Account account = accountRepository.findAccountByAccountCbu(cbu);
        if (account.getBalance() < sum) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        Transaction withdrawTransaction = new Transaction(-sum, account);
        account.setBalance(account.getBalance() - sum);
        accountRepository.save(account);
        transactionRepository.save(withdrawTransaction);
        return account;
    }

    @Transactional
    public Account deposit(Long cbu, Double sum) {

        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }

        Account account = accountRepository.findAccountByAccountCbu(cbu);
        Transaction depositTransaction = new Transaction(sum, account);
        if (sum >= 2000 && sum < 5000) {
            account.setBalance(account.getBalance() + sum*1.1);
        }
        else if (sum >= 5000) {
            account.setBalance(account.getBalance() + sum + 500);
        }
        else {
            account.setBalance(account.getBalance() + sum);

        }

        accountRepository.save(account);
        transactionRepository.save(depositTransaction);
        return account;
    }

}
