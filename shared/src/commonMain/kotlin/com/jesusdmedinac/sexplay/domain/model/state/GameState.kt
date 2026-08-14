package com.jesusdmedinac.sexplay.domain.model.state

import com.jesusdmedinac.sexplay.domain.model.ActionCard
import com.jesusdmedinac.sexplay.domain.model.GameMode
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel

sealed class GameState {
    data class SetupStep1Names(
        val player1Name: String = "",
        val player2Name: String = ""
    ) : GameState()
    
    data class SetupStep2Location(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean = false
    ) : GameState()

    data class SetupStep3Duration(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean,
        val gameMode: GameMode = GameMode.EXPRESS
    ) : GameState()

    data class SetupStep4Mood(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood = GameMood.MIXED
    ) : GameState()

    data class SetupStep5Intensity(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel = IntensityLevel.MEDIUM
    ) : GameState()

    data class SetupStep6Limits(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val selectedHardLimits: Set<HardLimit> = emptySet()
    ) : GameState()

    data class SetupStep7SafeWord(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean,
        val gameMode: GameMode,
        val selectedMood: GameMood,
        val maxIntensity: IntensityLevel,
        val selectedHardLimits: Set<HardLimit>,
        val safeWord: String = "Rojo"
    ) : GameState()
    
    data class Playing(
        val setupStep1Names: SetupStep1Names,
        val isRemote: Boolean,
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
    ) : GameState() {
        val player1Name: String get() = setupStep1Names.player1Name
        val player2Name: String get() = setupStep1Names.player2Name
    }
    
    data class WinnerChoice(
        val winnerName: String,
        val loserName: String,
        val maxIntensity: IntensityLevel,
        val isRemote: Boolean = false,
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
        val isRemote: Boolean = false,
        val totalTurnsPlayed: Int = 1,
        val durationSeconds: Long = 0L,
        val isSharedVictory: Boolean = false
    ) : GameState()
}
