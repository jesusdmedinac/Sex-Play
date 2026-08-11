package com.jesusdmedinac.sexplay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jesusdmedinac.sexplay.presentation.game.GameState
import com.jesusdmedinac.sexplay.presentation.game.GameViewModel
import com.jesusdmedinac.sexplay.presentation.ui.GameScreen
import com.jesusdmedinac.sexplay.presentation.ui.ResolutionScreen
import com.jesusdmedinac.sexplay.presentation.ui.SetupScreen
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
                is GameState.Setup -> {
                    SetupScreen(
                        onStartGame = { p1, p2, intensity ->
                            viewModel.setupGame(p1, p2, intensity)
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