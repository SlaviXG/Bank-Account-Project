package com.slavix.banking.ui

import com.slavix.banking.model.BankAccount
import com.slavix.banking.model.enums.AccountType
import com.slavix.banking.util.Console
import com.slavix.banking.util.InputValidator

class AccountOperationMenu(private val bankAccount: BankAccount) {

    fun displayMenu(){
        var userChoice: Int = 0
        var isSystemOpen = true

        while (isSystemOpen) {
            Console.println("What would you like to do?\n" +
                    "1. Check bank account balance\n" +
                    "2. Withdraw money\n" +
                    "3. Deposit money\n" +
                    "4. Close the app")
            Console.println("Choose an option (1, 2, 3 or 4)")
            val userChoiceString = Console.readLine()

            if(InputValidator.validInteger(userChoiceString)){
                userChoice = userChoiceString.toInt()
                Console.println("The selected option is: $userChoice")

                when(userChoice){
                    1 -> showAccountBalance()
                    2 -> showWithdrawal()
                    3 -> showDeposit()
                    4 -> {
                        isSystemOpen = false
                        println("The system is closed.")
                    }
                }
            }
            else{
                Console.println("The input is incorrect.")
                continue
            }
        }
    }

    private fun showAccountBalance() {
        println("The current balance is ${bankAccount.accountBalance()} dollars.")
        val input = Console.readLine()
        if (InputValidator.validInteger(input)) {
            val amount = input.toLong()
            bankAccount.deposit(amount)
            Console.println(bankAccount.lastOperationState().message)
            Console.println("Your new balance is ${bankAccount.accountBalance()} dollars.")
        } else {
            Console.println("Invalid amount. Please try again.")
        }
    }

    private fun showWithdrawal() {
        Console.println("Please enter the amount you would like to withdraw.")
        val input = Console.readLine()
        if (InputValidator.validInteger(input)) {
            val amount = input.toLong()
            bankAccount.withdraw(amount)
            Console.println(bankAccount.lastOperationState().message)
            Console.println("Your balance is ${bankAccount.accountBalance()} dollars.")
        } else {
            Console.println("Invalid amount. Please try again.")
        }
    }

    private fun showDeposit() {
        Console.println("Please enter the amount you would like to deposit.")
        val input = Console.readLine()
        if (InputValidator.validInteger(input)) {
            val amount = input.toLong()
            bankAccount.deposit(amount)
            Console.println(bankAccount.lastOperationState().message)
            Console.println("Your balance is ${bankAccount.accountBalance()} dollars.")
        } else {
            Console.println("Invalid amount. Please try again.")
        }
    }
}