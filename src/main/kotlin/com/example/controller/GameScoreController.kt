package com.example.controller

import com.example.exception.NotFoundException
import com.example.service.GameScoreService
import com.example.service.dto.GameScoreDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class GameScoreController(
    private val gameScoreService: GameScoreService
) {

    @GetMapping("/users/{userId}/scores")
    @Throws(NotFoundException::class)
    fun list(@PathVariable userId: UUID): List<GameScoreDTO> {
        return gameScoreService.list(userId)
    }
}