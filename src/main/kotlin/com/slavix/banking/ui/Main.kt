package com.slavix.banking.ui

import com.slavix.banking.model.BankAccount

fun main() {

    val accountCreationMenu = AccountCreationMenu()
    accountCreationMenu.displayMenu()
    val userAccount: BankAccount = accountCreationMenu.getUserAccount()
    val accountOperationMenu = AccountOperationMenu(userAccount)
    accountOperationMenu.displayMenu()
}