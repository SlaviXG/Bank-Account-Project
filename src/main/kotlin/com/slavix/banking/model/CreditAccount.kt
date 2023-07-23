package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountType

class CreditAccount : BankAccount (accountType = AccountType.CreditAccount){
    override fun withdraw(amount: Long) {
        TODO("Not yet implemented")
    }

    override fun deposit(amount: Long) {
        TODO("Not yet implemented")
    }
}