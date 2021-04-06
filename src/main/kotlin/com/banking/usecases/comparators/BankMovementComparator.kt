package com.banking.usecases.comparators

import com.banking.models.BankMovement
import kotlin.reflect.full.declaredMemberProperties

class BankMovementComparator(private val fieldName: String): Comparator<BankMovement> {
    override fun compare(o1: BankMovement, o2: BankMovement): Int {
        val comparingKey = BankMovement::class.declaredMemberProperties.firstOrNull { it.name === fieldName }
        return comparingKey?.get(o1).toString().compareTo(comparingKey?.get(o2).toString())
    }
}