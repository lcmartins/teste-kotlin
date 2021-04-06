package com.banking.usecases.bankmovementkeys

import com.banking.models.BankMovement

interface BankMovementKey {
    fun get(bankMovement: BankMovement): String
}