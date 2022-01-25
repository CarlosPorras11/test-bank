package org.iesfm.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Account {
    private final static Logger log = LoggerFactory.getLogger(Account.class);

    private String iban;
    private int balance;

    public Account(String iban, int balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void showAccount() {
        log.info("Iban: " + iban);
        log.info("Saldo: " + balance);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return balance == account.balance && Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance);
    }

    @Override
    public String toString() {
        return "org.iesfm.org.iesfm.Bank.Bank.Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
