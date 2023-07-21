package com.slavix.banking.ui

import com.slavix.banking.model.BankAccount
import com.slavix.banking.ui.AccountCreationMenu

fun main() {

    val accountCreationMenu = AccountCreationMenu()
    accountCreationMenu.displayMenu()
    val userAccount: BankAccount = accountCreationMenu.getUserAccount()
}