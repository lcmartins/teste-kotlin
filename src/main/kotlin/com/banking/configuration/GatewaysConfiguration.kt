package com.banking.configuration

import com.banking.gateways.PaymentListGateway
import com.banking.gateways.PaymentListGatewayImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.banking.repositories.FileRepository

@Configuration
class GatewaysConfiguration(private val fileRepository: FileRepository) {

    @Bean
    fun configurePaymentListGateway(): PaymentListGateway = PaymentListGatewayImpl(fileRepository)
}