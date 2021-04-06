package com.banking.extensions

import com.banking.models.BankMovement

fun BankMovement.isReceipt(rawValue: String): Boolean {
    return rawValue.replace(".", "").replace(",", ".").toDouble() > 0.0
}