package com.example.service.dto

import com.example.model.GameScore

class GameScoreDTO {

    var gameTitle: String? = null
    var score: Double? = null

    constructor(gameScore: GameScore) {
        this.gameTitle = gameScore.gameTitle
        this.score = gameScore.score
    }

    constructor()
}