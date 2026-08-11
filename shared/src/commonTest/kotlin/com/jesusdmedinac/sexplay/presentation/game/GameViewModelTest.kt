package com.jesusdmedinac.sexplay.presentation.game

import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import com.jesusdmedinac.sexplay.domain.model.state.GameState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameViewModelTest {

    @Test
    fun `Wizard navigation moves through steps correctly`() {
        val viewModel = GameViewModel()

        // Initial step
        assertTrue(viewModel.state.value is GameState.SetupStep1)

        // Step 1 -> Step 2
        viewModel.goToStep2("Alice", "Bob")
        val step2 = viewModel.state.value as GameState.SetupStep2
        assertEquals("Alice", step2.player1Name)
        assertEquals("Bob", step2.player2Name)

        // Step 2 -> Step 3
        viewModel.goToStep3(GameMood.ROMANTIC, IntensityLevel.HIGH)
        val step3 = viewModel.state.value as GameState.SetupStep3
        assertEquals(GameMood.ROMANTIC, step3.selectedMood)
        assertEquals(IntensityLevel.HIGH, step3.maxIntensity)

        // Finish setup
        viewModel.finishSetup("Red", setOf(HardLimit.TEMPERATURE_PLAY))
        val playing = viewModel.state.value as GameState.Playing
        assertEquals("Alice", playing.player1Name)
        assertEquals("Bob", playing.player2Name)
        assertEquals("Red", playing.safeWord)
        assertTrue(playing.selectedHardLimits.contains(HardLimit.TEMPERATURE_PLAY))
    }

    @Test
    fun `Deck filtering excludes hard limits and matches mood`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2("Alice", "Bob")
        viewModel.goToStep3(GameMood.ROMANTIC, IntensityLevel.LOW)
        viewModel.finishSetup("Red", setOf(HardLimit.TEMPERATURE_PLAY))

        val playing = viewModel.state.value as GameState.Playing
        
        // Assert all cards in activeDeck are ROMANTIC
        assertTrue(playing.activeDeck.all { it.mood == GameMood.ROMANTIC })
        
        // Assert no card in activeDeck has TEMPERATURE_PLAY tag
        assertFalse(playing.activeDeck.any { it.tags.contains(HardLimit.TEMPERATURE_PLAY) })
    }

    @Test
    fun `Surrender ends the game and sets winner choice`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2("Alice", "Bob")
        viewModel.goToStep3(GameMood.INTENSE, IntensityLevel.EXTREME)
        viewModel.finishSetup("Red", emptySet())

        // Alice surrenders
        viewModel.surrender()

        val state = viewModel.state.value
        assertTrue(state is GameState.WinnerChoice)
        assertEquals("Bob", state.winnerName)
        assertEquals("Alice", state.loserName)
        assertEquals(IntensityLevel.EXTREME, state.maxIntensity)
    }

    @Test
    fun `Winner selects consequence and receives title`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2("Alice", "Bob")
        viewModel.goToStep3(GameMood.MIXED, IntensityLevel.LOW)
        viewModel.finishSetup("Red", emptySet())
        viewModel.surrender()

        viewModel.selectConsequence(isReward = true)

        val state = viewModel.state.value
        assertTrue(state is GameState.Resolution)
        assertEquals("Bob", state.winnerName)
        assertTrue(state.consequenceTitle.isNotEmpty())
    }
}
