package com.banking.extensions

import java.math.BigDecimal
import java.time.LocalDate

val CURRENCY_SEPARATOR_SIMBOLS = "[,]{1,}"

fun String.buildSortableDate(): LocalDate {
    val separator = "-"
    val dateParts = this.split(separator)
    val day = dateParts[0]
    val month = dateParts[1]
    val builder = StringBuilder()

    builder.append(LocalDate.now().year).append(separator)
    when(month.toLowerCase()) {
        "jan" -> builder.append("01")
        "feb" -> builder.append("02")
        "mar" -> builder.append("03")
        "apr" -> builder.append("04")
        "may" -> builder.append("05")
        "jun" -> builder.append("06")
        "jul" -> builder.append("07")
        "ago" -> builder.append("08")
        "set" -> builder.append("09")
        "oct" -> builder.append("10")
        "nov" -> builder.append("11")
        "dec" -> builder.append("12")
    }
    builder.append(separator)
    builder.append(day)
    return LocalDate.parse(builder.toString())
}

fun String.bigDecimalReplacingCurrencySymbols(): BigDecimal {
    return this.replace(".", "").replace(Regex(CURRENCY_SEPARATOR_SIMBOLS), ".").toBigDecimal()
}