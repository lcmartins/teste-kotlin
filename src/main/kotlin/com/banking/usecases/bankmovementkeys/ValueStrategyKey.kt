package com.banking.usecases.bankmovementkeys

import com.banking.models.BankMovement
import org.springframework.format.number.CurrencyStyleFormatter
import java.text.NumberFormat
import java.util.Locale

class ValueStrategyKey: BankMovementKey {
    override fun get(bankMovement: BankMovement): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return formatter.format(bankMovement.value)
    }
}