package com.slavix.banking.model

import com.slavix.banking.model.enums.AccountType

abstract class BankAccount(val accountType: AccountType) {
    fun accountType(): AccountType {
        return accountType
    }

}