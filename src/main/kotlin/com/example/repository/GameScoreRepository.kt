package com.example.repository

import com.example.model.GameScore
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest
import java.util.UUID

@Repository
class GameScoreRepository(
    client: DynamoDbEnhancedClient
) {

    private val table = client.table("GameScores", TableSchema.fromBean(GameScore::class.java))

    fun list(userId: UUID): List<GameScore> {

        val key = Key.builder()
            .partitionValue(userId.toString())
            .build()

        val request = QueryEnhancedRequest.builder()
            .queryConditional(QueryConditional.keyEqualTo(key))
            .build()

        return table.query(request).items().toList()
    }
}