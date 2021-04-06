package com.banking.repositories

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.util.FileCopyUtils
import java.io.File
import java.io.FileReader
import java.util.regex.Pattern

class S3FileRepository : FileRepository {
    private val s3Dir = "/Users/luciano.martins/estudos/s3/get"
    override fun read(): MutableList<List<String>> {
        getFile()
        return FileReader("$s3Dir/data-saved.log")
            .readLines()
            .map { it.split(Pattern.compile("([\\s]){3,}")) }
            .filter { it.isNotEmpty() }
            .toMutableList()
    }

    override fun header() = listOf("Data", "Descricao", "Valor", "Categoria")

    private val bucketName = "banking-movement-bucket"
    private val keyName = "dados.log"

    private fun getFile() {
        //usa o arquivo ~/.aws/credentials para validar as credenciais
        AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
            .build()
            .apply {
                getObject(bucketName, keyName)
                    .apply {
                        objectContent
                            .apply {
                                val dir = File(s3Dir)
                                dir.mkdirs()
                                FileCopyUtils.copy(this.readAllBytes(), File(dir, "data-saved.log"))
                            }
                    }
            }
    }
}