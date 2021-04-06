package com.banking.usecases.bankmovementkeys

import com.banking.usecases.GroupWorkers
import com.banking.usecases.predicates.ExpensePredicate
import com.banking.usecases.predicates.MonthPredicate
import com.banking.usecases.predicates.ValuePredicate
import com.banking.usecases.comparators.BankMovementComparator

enum class BankMovementGroupingProp(val description: String) {
    EXPENSE("expenseName") {
        override fun workersByKey(): GroupWorkers {
            return GroupWorkers(ExpenseStrategyKey(), ExpensePredicate(), BankMovementComparator(this.description))
        }
    },
    MONTH("date") {
        override fun workersByKey(): GroupWorkers {
            return GroupWorkers(MonthStrategyKey(), MonthPredicate(), BankMovementComparator(this.description))
        }
    },
    VALUE("value") {
        override fun workersByKey(): GroupWorkers {
            return GroupWorkers(ValueStrategyKey(), ValuePredicate(), BankMovementComparator(this.description))
        }
    };

    abstract fun workersByKey(): GroupWorkers
}