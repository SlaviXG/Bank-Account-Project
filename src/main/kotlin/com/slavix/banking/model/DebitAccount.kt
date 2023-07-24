package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import com.slavix.banking.model.enums.AccountType

class DebitAccount : BankAccount (accountType = AccountType.DebitAccount) {
    override fun withdraw(amount: Long): Long {
        return if (accountBalance == 0L) {
            lastOperationState(AccountLastOperationState.FailureNullBalance)
            0L
        } else if (amount > accountBalance) {
            lastOperationState(AccountLastOperationState.FailureNotEnoughBalance)
            0L
        } else {
            lastOperationState(AccountLastOperationState.SuccessfulWithdrawal)
            accountBalance -= amount
            amount
        }
    }

    override fun deposit(amount: Long): Long {
        TODO("Not yet implemented")
    }
}