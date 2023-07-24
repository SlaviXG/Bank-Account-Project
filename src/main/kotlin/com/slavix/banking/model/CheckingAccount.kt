package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import com.slavix.banking.model.enums.AccountType

class CheckingAccount : BankAccount (accountType = AccountType.CheckingAccount){
    override fun withdraw(amount: Long): Long {
        accountBalance -= amount
        lastOperationState(AccountLastOperationState.WithdrawalSuccessful)
        return amount
    }

    override fun deposit(amount: Long): Long {
        accountBalance += amount
        lastOperationState(AccountLastOperationState.DepositSuccessful)
        return amount
    }
}