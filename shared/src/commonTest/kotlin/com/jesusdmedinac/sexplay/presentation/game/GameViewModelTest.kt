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

        assertTrue(viewModel.state.value is GameState.SetupStep1)

        viewModel.goToStep2("Alice", "Bob")
        val step2 = viewModel.state.value as GameState.SetupStep2
        assertEquals("Alice", step2.player1Name)
        assertEquals("Bob", step2.player2Name)

        viewModel.goToStep3(GameMood.ROMANTIC, IntensityLevel.HIGH)
        val step3 = viewModel.state.value as GameState.SetupStep3
        assertEquals(GameMood.ROMANTIC, step3.selectedMood)
        assertEquals(IntensityLevel.HIGH, step3.maxIntensity)

        viewModel.finishSetup("Red", setOf(HardLimit.TEMPERATURE_PLAY))
        val playing = viewModel.state.value as GameState.Playing
        assertEquals("Alice", playing.player1Name)
        assertEquals("Bob", playing.player2Name)
        assertEquals("Red", playing.safeWord)
        assertEquals(1, playing.turnCount)
        assertTrue(playing.selectedHardLimits.contains(HardLimit.TEMPERATURE_PLAY))
    }

    @Test
    fun `Next turn increments turn counter`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2("Alice", "Bob")
        viewModel.goToStep3(GameMood.MIXED, IntensityLevel.LOW)
        viewModel.finishSetup("Red", emptySet())

        var state = viewModel.state.value as GameState.Playing
        assertEquals(1, state.turnCount)

        viewModel.nextTurn()
        state = viewModel.state.value as GameState.Playing
        assertEquals(2, state.turnCount)
    }

    @Test
    fun `Deck filtering excludes hard limits and matches mood`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2("Alice", "Bob")
        viewModel.goToStep3(GameMood.ROMANTIC, IntensityLevel.LOW)
        viewModel.finishSetup("Red", setOf(HardLimit.TEMPERATURE_PLAY))

        val playing = viewModel.state.value as GameState.Playing
        assertTrue(playing.activeDeck.all { it.mood == GameMood.ROMANTIC })
        assertFalse(playing.activeDeck.any { it.tags.contains(HardLimit.TEMPERATURE_PLAY) })
    }

    @Test
    fun `Surrender ends the game and sets winner choice`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2("Alice", "Bob")
        viewModel.goToStep3(GameMood.INTENSE, IntensityLevel.EXTREME)
        viewModel.finishSetup("Red", emptySet())
        viewModel.nextTurn() // Turn 2

        viewModel.surrender()

        val state = viewModel.state.value
        assertTrue(state is GameState.WinnerChoice)
        assertEquals("Alice", state.winnerName)
        assertEquals("Bob", state.loserName)
        assertEquals(2, state.totalTurnsPlayed)
    }
}
