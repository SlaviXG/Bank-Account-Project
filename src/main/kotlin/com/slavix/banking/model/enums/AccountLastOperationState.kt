package com.slavix.banking.model.enums

import java.util.StringJoiner

enum class AccountLastOperationState (val code: Int, val message: String) {
    None(0, "There wasn't any operations."),
    DepositSuccessful(1, "Successfully deposited."),
    DepositSuccessfulPaidOff(2, "Successfully deposited. The account has been paid off."),
    DepositFailureAlreadyPaidOff(3, "Deposit failed. The account is already paid off."),
    DepositFailureGreaterAmount(4, "Deposit failed, you tried to pay off an amount greater than the credit balance."),
    WithdrawalSuccessful(5, "Successfully withdrawn."),
    WithdrawalFailureNullBalance(6, "Withdrawal failure. No money on this account."),
    WithdrawalFailureNotEnoughBalance(7, "Withdrawal failure. Not enough money on this account.")

}