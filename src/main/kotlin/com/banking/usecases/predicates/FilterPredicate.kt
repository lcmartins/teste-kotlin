package com.banking.usecases.predicates

import com.banking.models.BankMovement

interface FilterPredicate {
    fun get(): (BankMovement) -> Boolean
}