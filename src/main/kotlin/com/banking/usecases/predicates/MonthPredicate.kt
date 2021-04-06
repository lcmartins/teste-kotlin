package com.banking.usecases.predicates

import com.banking.models.BankMovement

class MonthPredicate: FilterPredicate {
    override fun get(): (BankMovement) -> Boolean {
        return { true }
    }
}