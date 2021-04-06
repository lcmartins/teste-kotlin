package com.banking.gateways

import com.banking.models.BankMovement

interface PaymentListGateway {
    fun listPayments(): List<BankMovement>
}