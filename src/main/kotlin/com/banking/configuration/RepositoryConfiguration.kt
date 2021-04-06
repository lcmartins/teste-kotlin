package com.banking.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.banking.repositories.FileRepository
import com.banking.repositories.S3FileRepository

@Configuration
class RepositoryConfiguration {

    @Bean
    fun configureFileRepository(): FileRepository = S3FileRepository()
}