package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import com.slavix.banking.model.enums.AccountType

class CreditAccount : BankAccount (accountType = AccountType.CreditAccount){
    override fun withdraw(amount: Long): Long {
        accountBalance -= amount
        lastOperationState(AccountLastOperationState.WithdrawalSuccessful)
        return amount
    }

    override fun deposit(amount: Long): Long {
        return if (accountBalance == 0L) {
            lastOperationState(AccountLastOperationState.DepositFailureAlreadyPaidOff)
            0L
        }
        else if (accountBalance + amount > 0L) {
            lastOperationState(AccountLastOperationState.DepositFailureGreaterAmount)
            0L
        }
        else {
            if (accountBalance + amount == 0L) {
                lastOperationState(AccountLastOperationState.DepositSuccessfulPaidOff)
            }
            else {
                lastOperationState(AccountLastOperationState.DepositSuccessful)
            }
            accountBalance += amount
            amount
        }
    }
}