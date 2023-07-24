package com.slavix.banking.model.enums

enum class AccountLastOperationState (val code: Int) {
    None(0),
    DepositSuccessful(1),
    DepositSuccessfulPaidOff(2),
    DepositFailureAlreadyPaidOff(3),
    DepositFailureGreaterAmount(4),
    WithdrawalSuccessful(5),
    WithdrawalFailureNullBalance(6),
    WithdrawalFailureNotEnoughBalance(7)

}