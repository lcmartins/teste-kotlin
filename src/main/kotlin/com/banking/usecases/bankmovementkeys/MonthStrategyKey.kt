package com.banking.usecases.bankmovementkeys

import com.banking.models.BankMovement
import java.time.format.TextStyle
import java.util.Locale

class MonthStrategyKey: BankMovementKey {
    override fun get(bankMovement: BankMovement): String {
        return bankMovement.date.month.getDisplayName(TextStyle.FULL, Locale("pt", "BR"))
    }
}