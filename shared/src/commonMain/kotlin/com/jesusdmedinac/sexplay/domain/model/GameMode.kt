package com.jesusdmedinac.sexplay.domain.model

enum class GameMode(
    val displayName: String,
    val maxCards: Int
) {
    EXPRESS("Modo Exprés (10 Cartas)", 10),
    STANDARD("Modo Estándar (20 Cartas)", 20),
    MARATHON("Modo Maratón (Hasta aguantar)", Int.MAX_VALUE)
}
