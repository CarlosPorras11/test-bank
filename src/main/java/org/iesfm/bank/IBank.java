package org.iesfm.bank;

import org.iesfm.bank.exceptions.AccountNotFoundException;
import org.iesfm.bank.exceptions.CustomerNotFoundException;
import org.iesfm.bank.exceptions.InsufficientFundsException;

public interface IBank {

    Customer getCustomer(String nif)
            throws CustomerNotFoundException;

    Account getAccount(String nif, String iban)
            throws CustomerNotFoundException,
            AccountNotFoundException;

    Account moneyDeposit(String nif, String iban, int amount)
            throws CustomerNotFoundException,
            AccountNotFoundException;

    Account moneyWithdrawal(String nif, String iban, int amount)
            throws CustomerNotFoundException,
            AccountNotFoundException,
            InsufficientFundsException;

    Account transaction(String nif, String ibanOrigin,
                        String ibanDestination, int amount)
            throws CustomerNotFoundException,
            AccountNotFoundException,
            InsufficientFundsException;
}
