package com.slavix.banking.model.enums

enum class AccountType(val displayName: String) {
    CreditAccount("Credit account"),
    DebitAccount("Debit account"),
    CheckingAccount("Checking account");
}