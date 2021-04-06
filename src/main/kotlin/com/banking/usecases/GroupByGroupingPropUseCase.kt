package com.banking.usecases

import com.banking.models.BankMovement
import com.banking.usecases.bankmovementkeys.BankMovementGroupingProp

class GroupByGroupingPropUseCase {
    fun groupExpenses(
        movements: List<BankMovement>,
        groupingKey: BankMovementGroupingProp
    ): MutableMap<String, MutableList<BankMovement>> {
        val groupWorkers = groupingKey.workersByKey()
        val map = mutableMapOf<String, MutableList<BankMovement>>()
        movements
            .sortedWith(groupWorkers.movementComparator)
            .filter { groupWorkers.filterPredicate.get()(it) }
            .forEach {
                val key = groupWorkers.bankMovementKey.get(it)
                if (map.containsKey(key)) {
                    map[key]?.add(it)
                } else {
                    map[key] = mutableListOf(it)
                }
            }
        return map
    }
}
