package com.banking.usecases.predicates

import com.banking.models.BankMovement

class ValuePredicate: FilterPredicate {
    override fun get(): (BankMovement) -> Boolean {
        return { true }
    }
}