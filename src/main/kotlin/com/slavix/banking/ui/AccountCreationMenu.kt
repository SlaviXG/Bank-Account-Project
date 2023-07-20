package com.slavix.banking.ui

import com.slavix.banking.ui.AccountSelectionMenu
import com.slavix.banking.util.Console

class AccountCreationMenu {
    fun displayMenu(){
        Console.println("Welcome to the account creation menu.")
        Console.println("What type of account would you like to create?")

        val accountSelectionMenu: AccountSelectionMenu = AccountSelectionMenu()
        accountSelectionMenu.displayMenu()
    }
}