package com.banking.usecases

import com.banking.models.BankMovement
import com.banking.usecases.bankmovementkeys.BankMovementKey
import com.banking.usecases.predicates.FilterPredicate

class GroupWorkers(val bankMovementKey: BankMovementKey,
                   val filterPredicate: FilterPredicate,
                   val movementComparator: Comparator<BankMovement>)