package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckingAccountTest {

    @Test
    fun deposit() {
        val bankAccount = CheckingAccount()
        bankAccount.deposit(100)
        assertEquals(100, bankAccount.accountBalance())
        assertEquals(bankAccount.lastOperationState(), AccountLastOperationState.DepositSuccessful)
    }

    @Test
    fun withdraw() {
        val bankAccount = CheckingAccount()
        assertEquals(bankAccount.accountBalance(), 0L)
        bankAccount.withdraw(100)
        assertEquals(bankAccount.accountBalance(), -100)
        assertEquals(bankAccount.lastOperationState(), AccountLastOperationState.WithdrawalSuccessful)
    }
}