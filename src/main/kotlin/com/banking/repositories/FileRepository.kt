package com.banking.repositories

interface FileRepository {
    fun read(): MutableList<List<String>>
    fun header(): List<String>
}