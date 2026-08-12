package com.jesusdmedinac.sexplay.domain.model

enum class GameMood(val displayName: String) {
    ROMANTIC("Romántico & Sensorial"),
    PLAYFUL("Juguetón & Atrevido"),
    INTENSE("Intenso & Erótico"),
    MIXED("Mezcla Total (Aleatorio)")
}

enum class HardLimit(val displayName: String) {
    PHYSICAL_CONTACT("Modo a Distancia (Sin contacto en persona)"),
    TEMPERATURE_PLAY("Excluir Hielo / Temperatura"),
    IMPACT_PLAY("Excluir Azotes / Spanking"),
    PERSONAL_QUESTIONS("Excluir Preguntas Íntimas / Pasado")
}

data class ActionCard(
    val id: String,
    val text: String,
    val mood: GameMood = GameMood.ROMANTIC,
    val tags: Set<HardLimit> = emptySet()
)

val baseActionCards = listOf(
    // Warm-up & Sensorial (ROMANTIC)
    ActionCard("1", "Besa apasionadamente el cuello de tu pareja durante 30 segundos.", GameMood.ROMANTIC, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("2", "Quítale una prenda a tu pareja usando solo tus dientes.", GameMood.PLAYFUL, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("3", "Susurra al oído de tu pareja qué es lo que más te excita de su cuerpo.", GameMood.ROMANTIC),
    ActionCard("4", "Acaricia suavemente el interior de los muslos de tu pareja durante un minuto.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("5", "Dale un masaje en los hombros a tu pareja por dos minutos.", GameMood.ROMANTIC, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("6", "Besa la zona del cuerpo de tu pareja que creas que es la más sensible.", GameMood.ROMANTIC, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("7", "Hazle a tu pareja tu mejor baile sensual en cámara por un minuto.", GameMood.PLAYFUL),
    ActionCard("8", "Pregunta: ¿Cuál es una fantasía que nunca me has contado?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("9", "Muestra en cámara un objeto o prenda que te gustaría usar juntos.", GameMood.ROMANTIC),
    ActionCard("10", "Usa un cubo de hielo para recorrer tu propio cuerpo en cámara.", GameMood.INTENSE, setOf(HardLimit.TEMPERATURE_PLAY)),
    
    // Teasing & Anticipation (ROMANTIC & PLAYFUL)
    ActionCard("11", "Susurra tres cosas sucias que quieras hacerle a tu pareja cuando se vean.", GameMood.INTENSE),
    ActionCard("12", "Lame tus propios labios mirándole fijamente a la cámara.", GameMood.ROMANTIC),
    ActionCard("13", "Mantén la mirada fija en tu pareja en cámara durante 30 segundos sin pestañear.", GameMood.ROMANTIC),
    ActionCard("14", "Pide a tu pareja que te dé una orden sencilla por audio/video y cúmplela.", GameMood.PLAYFUL),
    ActionCard("15", "Toca tu propio cuello a cámara muy lenta por 1 minuto imaginando que es tu pareja.", GameMood.ROMANTIC),
    ActionCard("16", "Dale 5 besos a la pantalla imaginando a tu pareja.", GameMood.ROMANTIC),
    ActionCard("17", "Envía una nota de voz o mensaje susurrando una fantasía.", GameMood.ROMANTIC),
    ActionCard("18", "Pregunta: ¿Cuál fue el momento exacto en que te sentiste más atraído/a por mí?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("19", "Abraza a tu pareja por la espalda y dale pequeños mordiscos en la oreja.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("20", "Ajusta la cámara para mostrar una vista tentadora por 30 segundos.", GameMood.INTENSE),

    // Intense & Direct Play (INTENSE)
    ActionCard("21", "Muerde suavemente tu labio inferior mientras miras la cámara intensamente.", GameMood.INTENSE),
    ActionCard("22", "Elige una posición sensual para mantener en cámara durante 1 minuto.", GameMood.ROMANTIC),
    ActionCard("23", "Hazle cosquillas eróticas a tu pareja en las zonas más sensibles de su cuerpo.", GameMood.PLAYFUL, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("24", "Pregunta: Si pudieras cambiar una sola regla de esta noche, ¿cuál sería?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("25", "Coloca tus manos en la cadera de tu pareja y pégala a ti durante 30 segundos.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("26", "Describe paso a paso cómo le acariciarías en este momento.", GameMood.INTENSE),
    ActionCard("27", "Quítate una prenda de vestir a elección de tu pareja frente a la cámara.", GameMood.PLAYFUL),
    ActionCard("28", "Toca tu propio cuerpo donde tu pareja te ordene durante 45 segundos.", GameMood.INTENSE),
    ActionCard("29", "Confiesa un lugar poco común en el que te gustaría tener un encuentro íntimo.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("30", "Besa la palma de tus manos y envíale ese beso a la cámara.", GameMood.ROMANTIC),

    // Escalation & Challenge (INTENSE & PLAYFUL)
    ActionCard("31", "Sopla suavemente al micrófono de tu cámara imaginando que es el oído de tu pareja.", GameMood.ROMANTIC),
    ActionCard("32", "Permite que tu pareja elija tus movimientos en los próximos 2 turnos.", GameMood.INTENSE),
    ActionCard("33", "Pregunta: ¿Qué posición o gesto te hace perder el control más rápido?", GameMood.INTENSE, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("34", "Acaricia tu cabello mientras le das una mirada profunda a tu pareja en pantalla.", GameMood.ROMANTIC),
    ActionCard("35", "Mueve tus caderas lentamente frente a la cámara durante 30 segundos.", GameMood.INTENSE),
    ActionCard("36", "Usa la yema de tus dedos para trazar figuras en el aire y que tu pareja las adivine.", GameMood.PLAYFUL),
    ActionCard("37", "Pide un deseo íntimo a distancia que tu pareja deba concederte en los próximos 5 minutos.", GameMood.INTENSE),
    ActionCard("38", "Sujeta suavemente las muñecas de tu pareja por encima de su cabeza.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("39", "Pregunta: ¿Hay algún accesorio o ropa especial que te gustaría que usara?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("40", "Dale a la cámara un beso apasionado de 45 segundos sin pausar.", GameMood.ROMANTIC)
)
