package com.jesusdmedinac.sexplay.presentation.game

import androidx.lifecycle.ViewModel
import com.jesusdmedinac.sexplay.domain.model.ActionCard
import com.jesusdmedinac.sexplay.domain.model.ConsequenceType
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

    private val _state = MutableStateFlow<GameState>(GameState.SetupStep1())
    val state: StateFlow<GameState> = _state.asStateFlow()

    fun goToStep2(player1Name: String, player2Name: String) {
        _state.value = GameState.SetupStep2(
            player1Name = player1Name.ifBlank { "Jugador 1" },
            player2Name = player2Name.ifBlank { "Jugador 2" }
        )
    }

    fun backToStep1() {
        val current = _state.value as? GameState.SetupStep2 ?: return
        _state.value = GameState.SetupStep1(
            player1Name = current.player1Name,
            player2Name = current.player2Name
        )
    }

    fun goToStep3(selectedMood: GameMood, maxIntensity: IntensityLevel) {
        val current = _state.value as? GameState.SetupStep2 ?: return
        _state.value = GameState.SetupStep3(
            player1Name = current.player1Name,
            player2Name = current.player2Name,
            selectedMood = selectedMood,
            maxIntensity = maxIntensity
        )
    }

    fun backToStep2() {
        val current = _state.value as? GameState.SetupStep3 ?: return
        _state.value = GameState.SetupStep2(
            player1Name = current.player1Name,
            player2Name = current.player2Name,
            selectedMood = current.selectedMood,
            maxIntensity = current.maxIntensity
        )
    }

    fun finishSetup(safeWord: String, selectedHardLimits: Set<HardLimit>) {
        val current = _state.value as? GameState.SetupStep3 ?: return
        val finalSafeWord = safeWord.ifBlank { "Rojo" }

        val filteredDeck = filterDeck(baseActionCards, current.selectedMood, selectedHardLimits)
        val initialCard = filteredDeck.randomOrNull() ?: ActionCard("0", "Besa apasionadamente a tu pareja.")

        _state.value = GameState.Playing(
            player1Name = current.player1Name,
            player2Name = current.player2Name,
            selectedMood = current.selectedMood,
            maxIntensity = current.maxIntensity,
            safeWord = finalSafeWord,
            selectedHardLimits = selectedHardLimits,
            activePlayerName = current.player1Name,
            currentCard = initialCard,
            activeDeck = filteredDeck,
            turnCount = 1
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

    fun nextTurn() {
        val currentState = _state.value as? GameState.Playing ?: return
        val nextPlayer = if (currentState.activePlayerName == currentState.player1Name) {
            currentState.player2Name
        } else {
            currentState.player1Name
        }
        val nextCard = currentState.activeDeck.randomOrNull() ?: currentState.currentCard

        _state.value = currentState.copy(
            activePlayerName = nextPlayer,
            currentCard = nextCard,
            turnCount = currentState.turnCount + 1
        )
    }

    fun surrender() {
        val currentState = _state.value as? GameState.Playing ?: return
        val winner = if (currentState.activePlayerName == currentState.player1Name) {
            currentState.player2Name
        } else {
            currentState.player1Name
        }
        val loser = currentState.activePlayerName

        _state.value = GameState.WinnerChoice(
            winnerName = winner,
            loserName = loser,
            maxIntensity = currentState.maxIntensity,
            totalTurnsPlayed = currentState.turnCount
        )
    }

    fun selectConsequence(isReward: Boolean) {
        val currentState = _state.value as? GameState.WinnerChoice ?: return

        val consequenceType = if (isReward) ConsequenceType.REWARD else ConsequenceType.PUNISHMENT
        val maxLevelInt = currentState.maxIntensity.level

        val validConsequences = allConsequences.filter {
            it.type == consequenceType && it.level.level <= maxLevelInt
        }

        val selected = validConsequences.randomOrNull()?.title ?: "Sin consecuencia disponible"

        _state.value = GameState.Resolution(
            winnerName = currentState.winnerName,
            loserName = currentState.loserName,
            consequenceTitle = selected,
            isReward = isReward,
            totalTurnsPlayed = currentState.totalTurnsPlayed
        )
    }

    fun resetGame() {
        _state.value = GameState.SetupStep1()
    }
}
