package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountLastOperationState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DebitAccountTest {

    @Test
    fun deposit() {
        val bankAccount = DebitAccount()
        assertEquals(100, bankAccount.deposit(100))
        assertEquals(AccountLastOperationState.DepositSuccessful, bankAccount.lastOperationState())
        assertEquals(100, bankAccount.accountBalance())
    }

    @Test
    fun withdraw() {
        val  bankAccount = DebitAccount()
        bankAccount.deposit(100)
        assertEquals(50, bankAccount.withdraw(50))
        assertEquals(AccountLastOperationState.WithdrawalSuccessful, bankAccount.lastOperationState())
    }

    @Test
    fun withdrawNullBalance() {
        val bankAccount = DebitAccount()
        assertEquals(bankAccount.withdraw(100), 0)
        assertEquals(bankAccount.lastOperationState(), AccountLastOperationState.WithdrawalFailureNullBalance)
        assertEquals(0, bankAccount.accountBalance())
    }

    @Test
    fun withdrawNotEnoughBalance() {
        val bankAccount = DebitAccount()
        bankAccount.deposit(50)
        assertEquals(0, bankAccount.withdraw(100))
        assertEquals(AccountLastOperationState.WithdrawalFailureNotEnoughBalance, bankAccount.lastOperationState())
    }
}