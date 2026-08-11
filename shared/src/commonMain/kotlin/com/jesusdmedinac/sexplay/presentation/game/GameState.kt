package com.jesusdmedinac.sexplay.presentation.game

import com.jesusdmedinac.sexplay.domain.model.ActionCard
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel

sealed class GameState {
    data object Setup : GameState()
    
    data class Playing(
        val player1Name: String,
        val player2Name: String,
        val maxIntensity: IntensityLevel,
        val activePlayerName: String,
        val currentCard: ActionCard
    ) : GameState()
    
    data class WinnerChoice(
        val winnerName: String,
        val loserName: String,
        val maxIntensity: IntensityLevel
    ) : GameState()
    
    data class Resolution(
        val winnerName: String,
        val loserName: String,
        val consequenceTitle: String,
        val isReward: Boolean
    ) : GameState()
}
