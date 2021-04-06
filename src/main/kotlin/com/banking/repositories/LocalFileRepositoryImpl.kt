package com.banking.repositories

import java.util.regex.Pattern
import java.util.stream.Collectors

class LocalFileRepositoryImpl : FileRepository {
    private val separatorPattern = """(\s){1,3)"""
    override fun read(): MutableList<List<String>> =
        LocalFileRepositoryImpl::class.java.getResource("/static/dados.log")
            .openStream()
            .bufferedReader()
            .lines()
            .map { it.split(Pattern.compile("([\\s]){3,}")) }
            .filter { it.isNotEmpty() }
            .collect(Collectors.toList())

    override fun header() = listOf("Data", "Descricao", "Valor", "Categoria")
}