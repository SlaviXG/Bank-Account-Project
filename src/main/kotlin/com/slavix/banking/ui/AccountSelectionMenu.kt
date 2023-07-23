package com.slavix.banking.ui

import com.slavix.banking.model.enums.AccountType
import com.slavix.banking.util.Console
import com.slavix.banking.util.InputValidator

class AccountSelectionMenu {
    private var accountType: AccountType? = null
    fun displayMenu() {
        var userChoice: Int = 0
        var i = 1

        for(accountType in AccountType.values()){
            Console.println("$i. ${accountType.displayName}")
            i++
        }


        while(accountType == null){
            Console.println("Choose an option (1, 2, or 3)")
            val userChoiceString = Console.readLine()

            if(InputValidator.validInteger(userChoiceString)){
                userChoice = userChoiceString.toInt()
                Console.println("The selected option is: $userChoice")

                accountType = when(userChoice){
                    1 -> AccountType.CreditAccount
                    2 -> AccountType.DebitAccount
                    3 -> AccountType.CheckingAccount
                    else -> {
                        Console.println("The input is incorrect.")
                        continue
                    }
                }
            }
            else{
                Console.println("The input is incorrect.")
                continue
            }
        }
    }

    fun getAccountType(): AccountType? {
        return accountType
    }
}