package com.banking.usecases.bankmovementkeys

import com.banking.models.BankMovement
import java.text.Normalizer

class ExpenseStrategyKey: BankMovementKey {
    private val UNCATEGORIZED_IDENTIFIER = "UNCATEGORIZED"

    override fun get(bankMovement: BankMovement): String {
        var key = bankMovement.expenseName
        key =  Normalizer
            .normalize(key, Normalizer.Form.NFD)
            .replace(Regex("[^\\p{ASCII}]"), "")
            .trim()
            .toLowerCase()
        if (key.isEmpty()) {
            key = UNCATEGORIZED_IDENTIFIER
        }
        return key
    }
}