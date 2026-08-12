package com.jesusdmedinac.sexplay.presentation.game

import com.jesusdmedinac.sexplay.domain.model.GameMode
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
    fun `Wizard navigation moves through all 7 single-action steps correctly`() {
        val viewModel = GameViewModel()

        assertTrue(viewModel.state.value is GameState.SetupStep1Names)

        // Step 1: Names
        viewModel.goToStep2Location("Alice", "Bob")
        assertTrue(viewModel.state.value is GameState.SetupStep2Location)

        // Step 2: Location
        viewModel.goToStep3Duration(isRemote = true)
        val step3 = viewModel.state.value as GameState.SetupStep3Duration
        assertTrue(step3.isRemote)

        // Step 3: Duration
        viewModel.goToStep4Mood(GameMode.EXPRESS)
        val step4 = viewModel.state.value as GameState.SetupStep4Mood
        assertEquals(GameMode.EXPRESS, step4.gameMode)

        // Step 4: Mood
        viewModel.goToStep5Intensity(GameMood.ROMANTIC)
        val step5 = viewModel.state.value as GameState.SetupStep5Intensity
        assertEquals(GameMood.ROMANTIC, step5.selectedMood)

        // Step 5: Intensity
        viewModel.goToStep6Limits(IntensityLevel.HIGH)
        val step6 = viewModel.state.value as GameState.SetupStep6Limits
        assertEquals(IntensityLevel.HIGH, step6.maxIntensity)

        // Step 6: Limits
        viewModel.goToStep7SafeWord(setOf(HardLimit.TEMPERATURE_PLAY))
        val step7 = viewModel.state.value as GameState.SetupStep7SafeWord
        assertTrue(step7.selectedHardLimits.contains(HardLimit.TEMPERATURE_PLAY))

        // Step 7: Finish
        viewModel.finishSetup("Red", currentTimeMillis = 1000L)
        val playing = viewModel.state.value as GameState.Playing
        assertEquals("Alice", playing.player1Name)
        assertEquals("Bob", playing.player2Name)
        assertEquals("Red", playing.safeWord)
        assertTrue(playing.selectedHardLimits.contains(HardLimit.PHYSICAL_CONTACT)) // Added because isRemote was true
        assertTrue(playing.selectedHardLimits.contains(HardLimit.TEMPERATURE_PLAY))
    }

    @Test
    fun `Enabling Remote Play Mode excludes all in-person physical contact cards`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2Location("Alice", "Bob")
        viewModel.goToStep3Duration(isRemote = true)
        viewModel.goToStep4Mood(GameMode.MARATHON)
        viewModel.goToStep5Intensity(GameMood.MIXED)
        viewModel.goToStep6Limits(IntensityLevel.EXTREME)
        viewModel.goToStep7SafeWord(emptySet())
        viewModel.finishSetup("Red")

        val playing = viewModel.state.value as GameState.Playing
        assertFalse(playing.activeDeck.any { it.tags.contains(HardLimit.PHYSICAL_CONTACT) })
        assertTrue(playing.activeDeck.isNotEmpty())
    }

    @Test
    fun `Reaching Express Mode card limit triggers Shared Victory`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2Location("Alice", "Bob")
        viewModel.goToStep3Duration(isRemote = false)
        viewModel.goToStep4Mood(GameMode.EXPRESS)
        viewModel.goToStep5Intensity(GameMood.MIXED)
        viewModel.goToStep6Limits(IntensityLevel.LOW)
        viewModel.goToStep7SafeWord(emptySet())
        viewModel.finishSetup("Red", currentTimeMillis = 10000L)

        repeat(9) {
            viewModel.nextTurn(currentTimeMillis = 15000L)
        }

        viewModel.nextTurn(currentTimeMillis = 70000L)

        val state = viewModel.state.value
        assertTrue(state is GameState.WinnerChoice)
        assertTrue(state.isSharedVictory)
        assertEquals(10, state.totalTurnsPlayed)
        assertEquals(60L, state.durationSeconds)
    }

    @Test
    fun `Surrender calculates elapsed time correctly`() {
        val viewModel = GameViewModel()
        viewModel.goToStep2Location("Alice", "Bob")
        viewModel.goToStep3Duration(isRemote = false)
        viewModel.goToStep4Mood(GameMode.MARATHON)
        viewModel.goToStep5Intensity(GameMood.INTENSE)
        viewModel.goToStep6Limits(IntensityLevel.EXTREME)
        viewModel.goToStep7SafeWord(emptySet())
        viewModel.finishSetup("Red", currentTimeMillis = 100000L)

        viewModel.surrender(currentTimeMillis = 220000L)

        val state = viewModel.state.value
        assertTrue(state is GameState.WinnerChoice)
        assertFalse(state.isSharedVictory)
        assertEquals(120L, state.durationSeconds)
    }
}
