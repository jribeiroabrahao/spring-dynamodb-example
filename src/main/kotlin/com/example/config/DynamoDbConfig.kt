package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class DynamoDbConfig {

    @Bean
    fun dynamoDbClient(): DynamoDbClient {

        return DynamoDbClient.builder()
            .credentialsProvider(DefaultCredentialsProvider.create())
            .build()
    }

    @Bean
    fun dynamoDbEnhancedClient(dynamoDbClient: DynamoDbClient?): DynamoDbEnhancedClient {

        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()
    }
}