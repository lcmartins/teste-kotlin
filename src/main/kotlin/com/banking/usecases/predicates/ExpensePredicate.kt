package com.banking.usecases.predicates

import com.banking.models.BankMovement

class ExpensePredicate : FilterPredicate {
    override fun get(): (BankMovement) -> Boolean {
        return { it.isExpense() }
    }
}