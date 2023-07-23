package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountType

class DebitAccount : BankAccount (accountType = AccountType.DebitAccount) {
    override fun withdraw(amount: Long) {
        TODO("Not yet implemented")
    }

    override fun deposit(amount: Long) {
        TODO("Not yet implemented")
    }
}