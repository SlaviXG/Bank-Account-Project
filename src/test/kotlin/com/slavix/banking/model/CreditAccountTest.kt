package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CreditAccountTest {

    @Test
    fun deposit() {
        val bankAccount = CreditAccount()
        assertEquals(100, bankAccount.withdraw(100))
        assertEquals(50, bankAccount.deposit(50))
        assertEquals(AccountLastOperationState.DepositSuccessful, bankAccount.lastOperationState())
        assertEquals(-50, bankAccount.accountBalance())
    }

    @Test
    fun depositPaidOff() {
        val bankAccount = CreditAccount()
        assertEquals(100, bankAccount.withdraw(100))
        assertEquals(100, bankAccount.deposit(100))
        assertEquals(AccountLastOperationState.DepositSuccessfulPaidOff, bankAccount.lastOperationState())
        assertEquals(0, bankAccount.accountBalance())
    }

    @Test
    fun depositAlreadyPaidOff() {
        val bankAccount = CreditAccount()
        assertEquals(0, bankAccount.deposit(100))
        assertEquals(AccountLastOperationState.DepositFailureAlreadyPaidOff, bankAccount.lastOperationState())
        assertEquals(0, bankAccount.accountBalance())
    }

    @Test
    fun withdraw() {
        val bankAccount = CreditAccount()
        assertEquals(100, bankAccount.withdraw(100))
        assertEquals(-100, bankAccount.accountBalance())
        assertEquals(AccountLastOperationState.WithdrawalSuccessful, bankAccount.lastOperationState())
    }
}