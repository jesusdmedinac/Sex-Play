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
import com.jesusdmedinac.sexplay.presentation.ui.GameScreen
import com.jesusdmedinac.sexplay.presentation.ui.ResolutionScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupWizardStep1
import com.jesusdmedinac.sexplay.presentation.ui.SetupWizardStep2
import com.jesusdmedinac.sexplay.presentation.ui.SetupWizardStep3
import com.jesusdmedinac.sexplay.presentation.ui.WinnerChoiceScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = viewModel { GameViewModel() }
        val state by viewModel.state.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
        ) {
            when (val currentState = state) {
                is GameState.SetupStep1 -> {
                    SetupWizardStep1(
                        state = currentState,
                        onNext = { p1, p2 ->
                            viewModel.goToStep2(p1, p2)
                        }
                    )
                }
                is GameState.SetupStep2 -> {
                    SetupWizardStep2(
                        state = currentState,
                        onBack = { viewModel.backToStep1() },
                        onNext = { mood, intensity ->
                            viewModel.goToStep3(mood, intensity)
                        }
                    )
                }
                is GameState.SetupStep3 -> {
                    SetupWizardStep3(
                        state = currentState,
                        onBack = { viewModel.backToStep2() },
                        onFinish = { safeWord, limits ->
                            viewModel.finishSetup(safeWord, limits)
                        }
                    )
                }
                is GameState.Playing -> {
                    GameScreen(
                        state = currentState,
                        onNextTurn = { viewModel.nextTurn() },
                        onSurrender = { viewModel.surrender() }
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