package com.jesusdmedinac.sexplay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jesusdmedinac.sexplay.domain.model.state.GameState
import com.jesusdmedinac.sexplay.presentation.game.GameViewModel
import com.jesusdmedinac.sexplay.presentation.theme.SexPlayTheme
import com.jesusdmedinac.sexplay.presentation.ui.GameScreen
import com.jesusdmedinac.sexplay.presentation.ui.ResolutionScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep1NamesScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep2LocationScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep3DurationScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep4MoodScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep5IntensityScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep6LimitsScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupStep7SafeWordScreen
import com.jesusdmedinac.sexplay.presentation.ui.WinnerChoiceScreen

@Composable
@Preview
fun App() {
    SexPlayTheme {
        val viewModel = viewModel { GameViewModel() }
        val state by viewModel.state.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
        ) {
            when (val currentState = state) {
                is GameState.SetupStep1Names -> {
                    SetupStep1NamesScreen(
                        state = currentState,
                        onNext = { p1, p2 ->
                            viewModel.goToStep2Location(p1, p2)
                        }
                    )
                }
                is GameState.SetupStep2Location -> {
                    SetupStep2LocationScreen(
                        state = currentState,
                        onBack = { viewModel.backToStep1() },
                        onNext = { isRemote ->
                            viewModel.goToStep3Duration(isRemote)
                        }
                    )
                }
                is GameState.SetupStep3Duration -> {
                    SetupStep3DurationScreen(
                        state = currentState,
                        onBack = { viewModel.backToStep2() },
                        onNext = { gameMode ->
                            viewModel.goToStep4Mood(gameMode)
                        }
                    )
                }
                is GameState.SetupStep4Mood -> {
                    SetupStep4MoodScreen(
                        state = currentState,
                        onBack = { viewModel.backToStep3() },
                        onNext = { mood ->
                            viewModel.goToStep5Intensity(mood)
                        }
                    )
                }
                is GameState.SetupStep5Intensity -> {
                    SetupStep5IntensityScreen(
                        state = currentState,
                        onBack = { viewModel.backToStep4() },
                        onNext = { intensity ->
                            viewModel.goToStep6Limits(intensity)
                        }
                    )
                }
                is GameState.SetupStep6Limits -> {
                    SetupStep6LimitsScreen(
                        state = currentState,
                        onBack = { viewModel.backToStep5() },
                        onNext = { limits ->
                            viewModel.goToStep7SafeWord(limits)
                        }
                    )
                }
                is GameState.SetupStep7SafeWord -> {
                    SetupStep7SafeWordScreen(
                        state = currentState,
                        onBack = { viewModel.backToStep6() },
                        onFinish = { safeWord ->
                            viewModel.finishSetup(safeWord, currentTimeMillis = System.currentTimeMillis())
                        }
                    )
                }
                is GameState.Playing -> {
                    GameScreen(
                        state = currentState,
                        onNextTurn = { viewModel.nextTurn(currentTimeMillis = System.currentTimeMillis()) },
                        onSurrender = { viewModel.surrender(currentTimeMillis = System.currentTimeMillis()) }
                    )
                }
                is GameState.WinnerChoice -> {
                    WinnerChoiceScreen(
                        state = currentState,
                        onSelectConsequence = { isReward ->
                            viewModel.selectConsequence(isReward)
                        }
                    )
                }
                is GameState.Resolution -> {
                    ResolutionScreen(
                        state = currentState,
                        onPlayAgain = { viewModel.resetGame() }
                    )
                }
            }
        }
    }
}