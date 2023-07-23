package com.slavix.banking.ui

import com.slavix.banking.model.*
import com.slavix.banking.model.enums.AccountType
import com.slavix.banking.util.Console

class AccountCreationMenu {
    private var userAccount: BankAccount? = null

    fun displayMenu(){
        Console.println("Welcome to the account creation menu.")
        Console.println("What type of account would you like to create?")

        val accountSelectionMenu: AccountSelectionMenu = AccountSelectionMenu()
        accountSelectionMenu.displayMenu()

        userAccount = when(accountSelectionMenu.getAccountType()){
            AccountType.CreditAccount -> CreditAccount()
            AccountType.DebitAccount -> DebitAccount()
            AccountType.CheckingAccount -> CheckingAccount()
            else -> {
                throw IllegalStateException("Unsupported account type")
            }
        }

        Console.println("You have created a ${userAccount!!.accountType().displayName.lowercase()}.")
    }

    fun getUserAccount() : BankAccount{
        return userAccount!!
    }
}