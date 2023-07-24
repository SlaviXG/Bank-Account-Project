package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import com.slavix.banking.model.enums.AccountType

class DebitAccount : BankAccount (accountType = AccountType.DebitAccount) {
    override fun withdraw(amount: Long): Long {
        return if (accountBalance == 0L) {
            lastOperationState(AccountLastOperationState.WithdrawalFailureNullBalance)
            0L
        } else if (amount > accountBalance) {
            lastOperationState(AccountLastOperationState.WithdrawalFailureNotEnoughBalance)
            0L
        } else {
            lastOperationState(AccountLastOperationState.WithdrawalSuccessful)
            accountBalance -= amount
            amount
        }
    }

    override fun deposit(amount: Long): Long {
        accountBalance += amount
        lastOperationState(AccountLastOperationState.DepositSuccessful)
        return amount
    }
}