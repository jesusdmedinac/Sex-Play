package com.jesusdmedinac.sexplay.domain.model.state

import com.jesusdmedinac.sexplay.domain.model.ActionCard
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel

sealed class GameState {
    data class SetupStep1(
        val player1Name: String = "Jugador 1",
        val player2Name: String = "Jugador 2"
    ) : GameState()
    
    data class SetupStep2(
        val player1Name: String,
        val player2Name: String,
        val selectedMood: GameMood = GameMood.MIXED,
        val maxIntensity: IntensityLevel = IntensityLevel.MEDIUM
    ) : GameState()

    data class SetupStep3(
        val player1Name: String,
        val player2Name: String,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val safeWord: String = "Rojo",
        val selectedHardLimits: Set<HardLimit> = emptySet()
    ) : GameState()
    
    data class Playing(
        val player1Name: String,
        val player2Name: String,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val safeWord: String,
        val selectedHardLimits: Set<HardLimit>,
        val activePlayerName: String,
        val currentCard: ActionCard,
        val activeDeck: List<ActionCard>
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
