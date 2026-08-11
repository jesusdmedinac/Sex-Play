package com.jesusdmedinac.sexplay.presentation.game

import androidx.lifecycle.ViewModel
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import com.jesusdmedinac.sexplay.domain.model.baseActionCards
import com.jesusdmedinac.sexplay.domain.model.allConsequences
import com.jesusdmedinac.sexplay.domain.model.ConsequenceType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow<GameState>(GameState.Setup)
    val state: StateFlow<GameState> = _state.asStateFlow()

    fun setupGame(player1Name: String, player2Name: String, maxIntensity: IntensityLevel) {
        val firstCard = baseActionCards.random()
        _state.value = GameState.Playing(
            player1Name = player1Name,
            player2Name = player2Name,
            maxIntensity = maxIntensity,
            activePlayerName = player1Name,
            currentCard = firstCard
        )
    }

    fun nextTurn() {
        val currentState = _state.value as? GameState.Playing ?: return
        val nextPlayer = if (currentState.activePlayerName == currentState.player1Name) {
            currentState.player2Name
        } else {
            currentState.player1Name
        }
        
        _state.value = currentState.copy(
            activePlayerName = nextPlayer,
            currentCard = baseActionCards.random()
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
            maxIntensity = currentState.maxIntensity
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
            isReward = isReward
        )
    }
    
    fun resetGame() {
        _state.value = GameState.Setup
    }
}
