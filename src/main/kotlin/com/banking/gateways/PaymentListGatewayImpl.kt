package com.banking.gateways

import com.banking.models.BankMovement
import com.banking.repositories.FileRepository
import com.banking.extensions.buildSortableDate
import com.banking.extensions.bigDecimalReplacingCurrencySymbols

class PaymentListGatewayImpl(private val fileRepository: FileRepository): PaymentListGateway {
    override fun listPayments(): List<BankMovement> {
        val bankingMovement = mutableListOf<BankMovement>()
        val readingResult = fileRepository.read()

        readingResult.filter { readingResult.indexOf(it) > 0 && it.isNotEmpty() }
            .forEach {
                val rawValue = getIndexValue(it, 2)
                val description = getIndexValue(it, 1)
                val rawDate = getIndexValue(it, 0)
                val sortableDate = rawDate.buildSortableDate()

                if(isReceipt(rawValue)) {
                    bankingMovement.add(BankMovement(value = rawValue.bigDecimalReplacingCurrencySymbols(), description = description,  sortableDate))
                } else {
                    val expenseType = getIndexValue(it, 3)
                    bankingMovement.add(BankMovement(value = rawValue.bigDecimalReplacingCurrencySymbols(), location = description, currency = "R$", sortableDate, expenseType))
                }
            }
        return bankingMovement
    }

    private fun getIndexValue(values: List<String>, index: Int): String {
        return if (values.size > index) values[index] else ""
    }


    private fun isReceipt(rawValue: String): Boolean {
        return rawValue.replace(".", "").replace(",", ".").toDouble() > 0.0
    }
}