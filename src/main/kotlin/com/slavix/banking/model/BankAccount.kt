package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountType

abstract class BankAccount(val accountType: AccountType) {

    protected var accountBalance: Long = 0L

    fun accountType(): AccountType {
        return accountType
    }

    fun accountBalance(): Long {
        return accountBalance
    }

    abstract fun withdraw(amount: Long)
    abstract fun deposit(amount: Long)
}