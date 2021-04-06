package com.banking.controllers

import com.banking.gateways.PaymentListGateway
import com.banking.models.BankMovement
import com.banking.usecases.GroupByGroupingPropUseCase
import com.banking.usecases.bankmovementkeys.BankMovementGroupingProp
import org.apache.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.lang.Exception

@RestController
@RequestMapping("/test")
class TestController(private val gateway: PaymentListGateway) {

    @GetMapping("/run")
    fun test(@RequestHeader("groupingKey") groupingKey: BankMovementGroupingProp): Mono<MutableMap<String, MutableList<BankMovement>>> {
        val response = gateway.listPayments()
        return Mono.just(
            GroupByGroupingPropUseCase().groupExpenses(response, groupingKey)
        )
    }

    @ExceptionHandler
   // @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(e: Exception?) {
        val x = e?.localizedMessage
       // LOGGER.warn("Returning HTTP 400 Bad Request", e)
    }

}