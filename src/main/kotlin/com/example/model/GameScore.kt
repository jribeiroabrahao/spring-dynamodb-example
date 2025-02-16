package com.example.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
class GameScore {

    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute(value = "UserId")
    var userId: String? = null

    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("GameTitle")
    var gameTitle: String? = null

    @get:DynamoDbAttribute("Score")
    var score: Double? = null

    override fun toString(): String {
        return "GameScore(userId=$userId, gameTitle=$gameTitle)"
    }
}