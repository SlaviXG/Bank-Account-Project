package com.slavix.banking.ui

import com.slavix.banking.model.AccountType
import com.slavix.banking.util.Console
import com.slavix.banking.util.InputValidator

class AccountSelectionMenu {
    private var accountType: AccountType? = null
    fun displayMenu() {
        var userChoice = 0

        while(accountType == null){
            Console.println("Choose an option (1, 2, or 3)")
            val userChoiceString = Console.readLine()

            if(InputValidator.validInteger(userChoiceString)){
                userChoice = userChoiceString.toInt()
                Console.println("The selected option is: $userChoice")

                accountType = when(userChoice){
                    1 -> AccountType.DebitAccount
                    2 -> AccountType.CreditAccount
                    3 -> AccountType.CheckingAccount
                    else -> {
                        continue
                    }
                }
            }
            else{
                continue
            }
        }
    }

    fun getAccountType(): AccountType? {
        return accountType
    }
}