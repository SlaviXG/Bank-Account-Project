package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountType
import com.slavix.banking.model.enums.AccountLastOperationState

abstract class BankAccount(val accountType: AccountType) {

    protected var accountBalance: Long = 0L
    private var lastOperationState: AccountLastOperationState = AccountLastOperationState.None

    fun accountType(): AccountType {
        return accountType
    }

    fun accountBalance(): Long {
        return accountBalance
    }

    fun lastOperationState(): AccountLastOperationState {
        return lastOperationState
    }

    protected fun lastOperationState(state: AccountLastOperationState) {
        lastOperationState = state
    }

    abstract fun withdraw(amount: Long): Long
    abstract fun deposit(amount: Long): Long
}