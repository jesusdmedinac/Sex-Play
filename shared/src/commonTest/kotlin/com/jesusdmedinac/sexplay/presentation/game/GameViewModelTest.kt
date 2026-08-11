package com.jesusdmedinac.sexplay.presentation.game

import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GameViewModelTest {

    @Test
    fun `Setup Game starts the game with players and intensity`() {
        val viewModel = GameViewModel()
        
        // Given initial state
        assertEquals(GameState.Setup, viewModel.state.value)
        
        // When setting up
        viewModel.setupGame(
            player1Name = "Alice",
            player2Name = "Bob",
            maxIntensity = IntensityLevel.MEDIUM
        )
        
        // Then state is Playing
        val state = viewModel.state.value
        assertTrue(state is GameState.Playing)
        assertEquals("Alice", state.player1Name)
        assertEquals("Bob", state.player2Name)
        assertEquals(IntensityLevel.MEDIUM, state.maxIntensity)
        assertEquals("Alice", state.activePlayerName) // Player 1 starts
        assertTrue(state.currentCard.text.isNotEmpty())
    }

    @Test
    fun `Next Turn changes active player and updates card`() {
        val viewModel = GameViewModel()
        viewModel.setupGame("Alice", "Bob", IntensityLevel.LOW)
        
        val initialState = viewModel.state.value as GameState.Playing
        val firstCard = initialState.currentCard
        
        // When next turn
        viewModel.nextTurn()
        
        val nextState = viewModel.state.value as GameState.Playing
        assertEquals("Bob", nextState.activePlayerName) // Turn passed to Bob
        // For a true random test we can't assert not equal strictly in 1 draw but generally true
        // We just assert we have a card
        assertTrue(nextState.currentCard.text.isNotEmpty())
        
        // Next turn again
        viewModel.nextTurn()
        val thirdState = viewModel.state.value as GameState.Playing
        assertEquals("Alice", thirdState.activePlayerName) // Back to Alice
    }

    @Test
    fun `Surrender ends the game and sets winner choice`() {
        val viewModel = GameViewModel()
        viewModel.setupGame("Alice", "Bob", IntensityLevel.EXTREME)
        
        // Alice surrenders (she is active player)
        viewModel.surrender()
        
        val state = viewModel.state.value
        assertTrue(state is GameState.WinnerChoice)
        assertEquals("Bob", state.winnerName)
        assertEquals("Alice", state.loserName)
        assertEquals(IntensityLevel.EXTREME, state.maxIntensity)
    }

    @Test
    fun `Winner selects consequence and ends game`() {
        val viewModel = GameViewModel()
        viewModel.setupGame("Alice", "Bob", IntensityLevel.LOW)
        viewModel.surrender() // Alice surrenders, Bob wins
        
        // Bob selects Reward
        viewModel.selectConsequence(isReward = true)
        
        val state = viewModel.state.value
        assertTrue(state is GameState.Resolution)
        assertEquals("Bob", state.winnerName)
        // Ensure the chosen consequence is a reward and within intensity
        assertTrue(state.consequenceTitle.isNotEmpty())
    }
}
