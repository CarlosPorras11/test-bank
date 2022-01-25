package org.iesfm.bank;

import org.iesfm.bank.exceptions.AccountNotFoundException;
import org.iesfm.bank.exceptions.CustomerNotFoundException;
import org.iesfm.bank.exceptions.InsufficientFundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

public class Bank implements IBank {
    private final static Logger log = LoggerFactory.getLogger(Bank.class);

    private String name;
    private Customer[] customers;


    public Bank(String name, Customer[] customers) {
        this.name = name;
        this.customers = customers;
    }

    public void showBank() {
        log.info("Nombre del banco: " + name);
        log.info("Listado de clientes");
        for (Customer customer : customers) {
            customer.showCustomer();
        }
    }

    @Override
    public Customer getCustomer(String nif) throws CustomerNotFoundException {
        Customer result = null;
        for (Customer customer : customers) {
            if (nif.equals(customer.getNif())) {
                return customer;
            }
        }
        if (result == null) {
            throw new CustomerNotFoundException();
        }
        return result;
    }

    @Override
    public Account getAccount(String nif, String iban) throws CustomerNotFoundException, AccountNotFoundException {
        Customer customer = getCustomer(nif);
        for (Account account : customer.getAccounts()) {
            if (iban.equals(account.getIban())) {
                return account;
            }
        }
        throw new AccountNotFoundException();
    }


    @Override
    public Account moneyDeposit(String nif, String iban, int amount)
            throws CustomerNotFoundException, AccountNotFoundException {
        Account account = getAccount(nif, iban);
        account.
        return null;
    }

    @Override
    public Account moneyWithdrawal(String nif, String iban, int amount)
            throws CustomerNotFoundException, AccountNotFoundException, InsufficientFundsException {
        return null;
    }

    @Override
    public Account transaction(String nif, String ibanOrigin, String ibanDestination, int amount)
            throws CustomerNotFoundException, AccountNotFoundException, InsufficientFundsException {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Arrays.equals(customers, bank.customers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(customers);
        return result;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + Arrays.toString(customers) +
                '}';
    }
}
