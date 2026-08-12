package com.jesusdmedinac.sexplay.domain.model.state

import com.jesusdmedinac.sexplay.domain.model.ActionCard
import com.jesusdmedinac.sexplay.domain.model.GameMode
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel

sealed class GameState {
    data class SetupStep1Names(
        val player1Name: String = "Jugador 1",
        val player2Name: String = "Jugador 2"
    ) : GameState()
    
    data class SetupStep2Location(
        val player1Name: String,
        val player2Name: String,
        val isRemote: Boolean = false
    ) : GameState()

    data class SetupStep3Duration(
        val player1Name: String,
        val player2Name: String,
        val isRemote: Boolean,
        val gameMode: GameMode = GameMode.EXPRESS
    ) : GameState()

    data class SetupStep4Mood(
        val player1Name: String,
        val player2Name: String,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood = GameMood.MIXED
    ) : GameState()

    data class SetupStep5Intensity(
        val player1Name: String,
        val player2Name: String,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel = IntensityLevel.MEDIUM
    ) : GameState()

    data class SetupStep6Limits(
        val player1Name: String,
        val player2Name: String,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val selectedHardLimits: Set<HardLimit> = emptySet()
    ) : GameState()

    data class SetupStep7SafeWord(
        val player1Name: String,
        val player2Name: String,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val selectedHardLimits: Set<HardLimit>,
        val safeWord: String = "Rojo"
    ) : GameState()
    
    data class Playing(
        val player1Name: String,
        val player2Name: String,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val gameMode: GameMode,
        val safeWord: String,
        val selectedHardLimits: Set<HardLimit>,
        val activePlayerName: String,
        val currentCard: ActionCard,
        val activeDeck: List<ActionCard>,
        val turnCount: Int = 1,
        val startTimeMillis: Long = 0L
    ) : GameState()
    
    data class WinnerChoice(
        val winnerName: String,
        val loserName: String,
        val maxIntensity: IntensityLevel,
        val totalTurnsPlayed: Int = 1,
        val durationSeconds: Long = 0L,
        val isSharedVictory: Boolean = false
    ) : GameState()
    
    data class Resolution(
        val winnerName: String,
        val loserName: String,
        val consequenceTitle: String,
        val consequenceDescription: String = "",
        val isReward: Boolean,
        val totalTurnsPlayed: Int = 1,
        val durationSeconds: Long = 0L,
        val isSharedVictory: Boolean = false
    ) : GameState()
}
