package com.banking.models

import java.math.BigDecimal
import java.time.LocalDate

data class BankMovement(
    val value: BigDecimal,
    val location: String,
    val currency: String?,
    val date: LocalDate,
    val expenseName: String?
) {
    constructor(
        value: BigDecimal,
        description: String,
        sortableDate: LocalDate
    ) : this(value, description, "R$", sortableDate, null)

    fun isExpense(): Boolean {
        return value < BigDecimal.ZERO
    }
}