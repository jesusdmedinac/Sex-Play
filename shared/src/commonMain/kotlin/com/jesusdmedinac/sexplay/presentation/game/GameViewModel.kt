package com.jesusdmedinac.sexplay.presentation.game

import androidx.lifecycle.ViewModel
import com.jesusdmedinac.sexplay.domain.model.ActionCard
import com.jesusdmedinac.sexplay.domain.model.ConsequenceType
import com.jesusdmedinac.sexplay.domain.model.GameMode
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import com.jesusdmedinac.sexplay.domain.model.allConsequences
import com.jesusdmedinac.sexplay.domain.model.baseActionCards
import com.jesusdmedinac.sexplay.domain.model.state.GameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow<GameState>(GameState.SetupStep1Names())
    val state: StateFlow<GameState> = _state.asStateFlow()

    // Step 1 -> Step 2
    fun goToStep2Location(setupStep1Names: GameState.SetupStep1Names) {
        _state.value = GameState.SetupStep2Location(
            setupStep1Names = setupStep1Names,
        )
    }

    // Step 2 -> Step 3
    fun goToStep3Duration(isRemote: Boolean) {
        val current = _state.value as? GameState.SetupStep2Location ?: return
        _state.value = GameState.SetupStep3Duration(
            setupStep1Names = current.setupStep1Names,
            isRemote = isRemote
        )
    }

    // Step 3 -> Step 4
    fun goToStep4Mood(gameMode: GameMode) {
        val current = _state.value as? GameState.SetupStep3Duration ?: return
        _state.value = GameState.SetupStep4Mood(
            setupStep1Names = current.setupStep1Names,
            isRemote = current.isRemote,
            gameMode = gameMode
        )
    }

    // Step 4 -> Step 5
    fun goToStep5Intensity(selectedMood: GameMood) {
        val current = _state.value as? GameState.SetupStep4Mood ?: return
        _state.value = GameState.SetupStep5Intensity(
            setupStep1Names = current.setupStep1Names,
            isRemote = current.isRemote,
            gameMode = current.gameMode,
            selectedMood = selectedMood
        )
    }

    // Step 5 -> Step 6
    fun goToStep6Limits(maxIntensity: IntensityLevel) {
        val current = _state.value as? GameState.SetupStep5Intensity ?: return
        _state.value = GameState.SetupStep6Limits(
            setupStep1Names = current.setupStep1Names,
            isRemote = current.isRemote,
            gameMode = current.gameMode,
            selectedMood = current.selectedMood,
            maxIntensity = maxIntensity
        )
    }

    // Step 6 -> Step 7
    fun goToStep7SafeWord(selectedHardLimits: Set<HardLimit>) {
        val current = _state.value as? GameState.SetupStep6Limits ?: return
        _state.value = GameState.SetupStep7SafeWord(
            setupStep1Names = current.setupStep1Names,
            isRemote = current.isRemote,
            gameMode = current.gameMode,
            selectedMood = current.selectedMood,
            maxIntensity = current.maxIntensity,
            selectedHardLimits = selectedHardLimits
        )
    }

    // Back handlers
    fun backToStep1() {
        val current = _state.value as? GameState.SetupStep2Location ?: return
        val setupStep1Names = current.setupStep1Names
        _state.value = setupStep1Names
    }

    fun backToStep2() {
        val current = _state.value as? GameState.SetupStep3Duration ?: return
        val setupStep1Names = current.setupStep1Names
        _state.value = GameState.SetupStep2Location(setupStep1Names, current.isRemote)
    }

    fun backToStep3() {
        val current = _state.value as? GameState.SetupStep4Mood ?: return
        val setupStep1Names = current.setupStep1Names
        _state.value = GameState.SetupStep3Duration(setupStep1Names, current.isRemote, current.gameMode)
    }

    fun backToStep4() {
        val current = _state.value as? GameState.SetupStep5Intensity ?: return
        val setupStep1Names = current.setupStep1Names
        _state.value = GameState.SetupStep4Mood(setupStep1Names, current.isRemote, current.gameMode, current.selectedMood)
    }

    fun backToStep5() {
        val current = _state.value as? GameState.SetupStep6Limits ?: return
        val setupStep1Names = current.setupStep1Names
        _state.value = GameState.SetupStep5Intensity(setupStep1Names, current.isRemote, current.gameMode, current.selectedMood, current.maxIntensity)
    }

    fun backToStep6() {
        val current = _state.value as? GameState.SetupStep7SafeWord ?: return
        val setupStep1Names = current.setupStep1Names
        _state.value = GameState.SetupStep6Limits(setupStep1Names, current.isRemote, current.gameMode, current.selectedMood, current.maxIntensity, current.selectedHardLimits)
    }

    fun finishSetup(safeWord: String, currentTimeMillis: Long = 0L) {
        val current = _state.value as? GameState.SetupStep7SafeWord ?: return
        val finalSafeWord = safeWord.ifBlank { "Rojo" }

        val finalLimits = if (current.isRemote) {
            current.selectedHardLimits + HardLimit.PHYSICAL_CONTACT
        } else {
            current.selectedHardLimits
        }

        val filteredDeck = filterDeck(baseActionCards, current.selectedMood, finalLimits)
        val initialCard = filteredDeck.randomOrNull() ?: ActionCard("0", "Besa apasionadamente a tu pareja.")

        _state.value = GameState.Playing(
            setupStep1Names = current.setupStep1Names,
            selectedMood = current.selectedMood,
            maxIntensity = current.maxIntensity,
            gameMode = current.gameMode,
            safeWord = finalSafeWord,
            selectedHardLimits = finalLimits,
            activePlayerName = current.setupStep1Names.player1Name,
            currentCard = initialCard,
            activeDeck = filteredDeck,
            turnCount = 1,
            startTimeMillis = currentTimeMillis
        )
    }

    fun filterDeck(
        deck: List<ActionCard>,
        mood: GameMood,
        hardLimits: Set<HardLimit>
    ): List<ActionCard> {
        return deck.filter { card ->
            val matchesMood = if (mood == GameMood.MIXED) true else card.mood == mood
            val respectsLimits = card.tags.none { it in hardLimits }
            matchesMood && respectsLimits
        }
    }

    fun nextTurn(currentTimeMillis: Long = 0L) {
        val currentState = _state.value as? GameState.Playing ?: return

        val setupStep1Names = currentState.setupStep1Names
        if (currentState.turnCount >= currentState.gameMode.maxCards) {
            val duration = calculateDuration(currentState.startTimeMillis, currentTimeMillis)
            _state.value = GameState.WinnerChoice(
                winnerName = "${setupStep1Names.player1Name} y ${setupStep1Names.player2Name}",
                loserName = "Nadie",
                maxIntensity = currentState.maxIntensity,
                totalTurnsPlayed = currentState.turnCount,
                durationSeconds = duration,
                isSharedVictory = true
            )
            return
        }

        val nextPlayer = if (currentState.activePlayerName == setupStep1Names.player1Name) {
            setupStep1Names.player2Name
        } else {
            setupStep1Names.player1Name
        }
        val nextCard = currentState.activeDeck.randomOrNull() ?: currentState.currentCard

        _state.value = currentState.copy(
            activePlayerName = nextPlayer,
            currentCard = nextCard,
            turnCount = currentState.turnCount + 1
        )
    }

    fun surrender(currentTimeMillis: Long = 0L) {
        val currentState = _state.value as? GameState.Playing ?: return
        val setupStep1Names = currentState.setupStep1Names
        val winner = if (currentState.activePlayerName == setupStep1Names.player1Name) {
            setupStep1Names.player2Name
        } else {
            setupStep1Names.player1Name
        }
        val loser = currentState.activePlayerName
        val duration = calculateDuration(currentState.startTimeMillis, currentTimeMillis)

        _state.value = GameState.WinnerChoice(
            winnerName = winner,
            loserName = loser,
            maxIntensity = currentState.maxIntensity,
            totalTurnsPlayed = currentState.turnCount,
            durationSeconds = duration,
            isSharedVictory = false
        )
    }

    fun selectConsequence(isReward: Boolean) {
        val currentState = _state.value as? GameState.WinnerChoice ?: return

        val consequenceType = if (isReward) ConsequenceType.REWARD else ConsequenceType.PUNISHMENT
        val maxLevelInt = currentState.maxIntensity.level

        val validConsequences = allConsequences.filter {
            it.type == consequenceType && it.level.level <= maxLevelInt
        }

        val selected = validConsequences.randomOrNull()
        val title = selected?.title ?: "Sin consecuencia disponible"
        val desc = selected?.description ?: ""

        _state.value = GameState.Resolution(
            winnerName = currentState.winnerName,
            loserName = currentState.loserName,
            consequenceTitle = title,
            consequenceDescription = desc,
            isReward = isReward,
            totalTurnsPlayed = currentState.totalTurnsPlayed,
            durationSeconds = currentState.durationSeconds,
            isSharedVictory = currentState.isSharedVictory
        )
    }

    private fun calculateDuration(startTime: Long, endTime: Long): Long {
        if (startTime == 0L || endTime == 0L || endTime < startTime) return 0L
        return (endTime - startTime) / 1000L
    }

    fun resetGame() {
        _state.value = GameState.SetupStep1Names()
    }
}
