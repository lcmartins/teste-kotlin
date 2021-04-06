package com.banking.gateways

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import java.io.File
import org.springframework.util.FileCopyUtils


class S3Gateway {
    val bucketName = "banking-movement-bucket"
    val keyName = "dados.log"

    fun getFile(accessKey: String, secretkey: String ) {
        AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
            .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(accessKey, secretkey)))
            .build()
            .apply {
                getObject(bucketName, keyName).apply {
                    objectContent.apply {
                        val dir = File("/Users/luciano.martins/estudos/s3/get")
                        dir.mkdirs()
                        FileCopyUtils.copy(this.readAllBytes(), File(dir, "log.log"))
                    }
                }
            }
    }

}