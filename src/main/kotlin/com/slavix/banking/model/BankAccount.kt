package com.slavix.banking.model

enum class AccountType(val displayName: String) {
    CreditAccount("Credit account"),
    DebitAccount("Debit account"),
    CheckingAccount("Checking account");
}

abstract class BankAccount{
}