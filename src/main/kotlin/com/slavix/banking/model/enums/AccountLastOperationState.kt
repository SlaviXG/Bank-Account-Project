package com.slavix.banking.model.enums

enum class AccountLastOperationState (val code: Int) {
    None(0),
    SuccessfulDeposit(1),
    SuccessfulWithdrawal(2),
    FailureNullBalance(3),
    FailureNotEnoughBalance(4)
}