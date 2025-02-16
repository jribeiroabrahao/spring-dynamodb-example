package com.example.service

import com.example.exception.NotFoundException
import com.example.model.GameScore
import com.example.repository.GameScoreRepository
import com.example.service.dto.GameScoreDTO
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GameScoreService(
    private val gameScoreRepository: GameScoreRepository
) {

    @Throws(NotFoundException::class)
    fun list(userId: UUID): List<GameScoreDTO> {

        val items = gameScoreRepository.list(userId)

        if (items.isEmpty()) {
            throw NotFoundException("Nenhum resultado encontrado.")
        }

        return items.map { GameScoreDTO(it) }
    }
}