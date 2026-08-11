package com.jesusdmedinac.sexplay.domain.model

enum class GameMood(val displayName: String) {
    ROMANTIC("Romántico & Sensorial"),
    PLAYFUL("Juguetón & Atrevido"),
    INTENSE("Intenso & Erótico"),
    MIXED("Mezcla Total (Aleatorio)")
}

enum class HardLimit(val displayName: String) {
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
    ActionCard("1", "Besa apasionadamente el cuello de tu pareja durante 30 segundos.", GameMood.ROMANTIC),
    ActionCard("2", "Quítale una prenda a tu pareja usando solo tus dientes.", GameMood.PLAYFUL),
    ActionCard("3", "Susurra al oído de tu pareja qué es lo que más te excita de su cuerpo.", GameMood.ROMANTIC),
    ActionCard("4", "Acaricia suavemente el interior de los muslos de tu pareja durante un minuto.", GameMood.INTENSE),
    ActionCard("5", "Dale un masaje en los hombros a tu pareja por dos minutos.", GameMood.ROMANTIC),
    ActionCard("6", "Besa la zona del cuerpo de tu pareja que creas que es la más sensible.", GameMood.ROMANTIC),
    ActionCard("7", "Hazle a tu pareja tu mejor baile sensual por un minuto.", GameMood.PLAYFUL),
    ActionCard("8", "Pregunta: ¿Cuál es una fantasía que nunca me has contado?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("9", "Venda los ojos de tu pareja y dale de probar algo dulce o salado.", GameMood.ROMANTIC),
    ActionCard("10", "Usa un cubo de hielo para recorrer la espalda o torso de tu pareja.", GameMood.INTENSE, setOf(HardLimit.TEMPERATURE_PLAY)),
    
    // Teasing & Anticipation (ROMANTIC & PLAYFUL)
    ActionCard("11", "Susurra tres cosas sucias que quieras hacerle a tu pareja esta noche.", GameMood.INTENSE),
    ActionCard("12", "Traza una línea con la punta de tu lengua desde el ombligo hasta los labios de tu pareja.", GameMood.ROMANTIC),
    ActionCard("13", "Mantén la mirada fija en los ojos de tu pareja durante 30 segundos sin pestañear ni tocarse.", GameMood.ROMANTIC),
    ActionCard("14", "Pide a tu pareja que te dé una orden sencilla y cúmplela inmediatamente.", GameMood.PLAYFUL),
    ActionCard("15", "Toca a tu pareja usando únicamente las puntas de tus dedos a cámara muy lenta por 1 minuto.", GameMood.ROMANTIC),
    ActionCard("16", "Dale 5 besos en lugares donde nunca antes le hayas besado.", GameMood.ROMANTIC),
    ActionCard("17", "Acaricia los labios de tu pareja con tus dedos suavemente mientras le miras fijamente.", GameMood.ROMANTIC),
    ActionCard("18", "Pregunta: ¿Cuál fue el momento exacto en que te sentiste más atraído/a por mí?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("19", "Abraza a tu pareja por la espalda y dale pequeños mordiscos en la oreja o el hombro.", GameMood.INTENSE),
    ActionCard("20", "Pasa la mano por debajo de la ropa de tu pareja sin quitarle ninguna prenda por 45 segundos.", GameMood.INTENSE),

    // Intense & Direct Play (INTENSE)
    ActionCard("21", "Muerde suavemente el labio inferior de tu pareja y luego bésala con intensidad.", GameMood.INTENSE),
    ActionCard("22", "Elige una posición para que ambos la mantengan abrazados durante 1 minuto sin moverse.", GameMood.ROMANTIC),
    ActionCard("23", "Hazle cosquillas eróticas a tu pareja en las zonas más sensibles de su cuerpo.", GameMood.PLAYFUL),
    ActionCard("24", "Pregunta: Si pudieras cambiar una sola regla de esta noche, ¿cuál sería?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("25", "Coloca tus manos en la cadera de tu pareja y pégala a ti durante 30 segundos.", GameMood.INTENSE),
    ActionCard("26", "Lame el cuello de tu pareja de abajo hacia arriba despacio.", GameMood.INTENSE),
    ActionCard("27", "Quítate una prenda de vestir a elección de tu pareja.", GameMood.PLAYFUL),
    ActionCard("28", "Dale a tu pareja la oportunidad de tocarte donde quiera durante 45 segundos sin que tú puedas moverte.", GameMood.INTENSE),
    ActionCard("29", "Confiesa un lugar poco común en el que te gustaría tener un encuentro íntimo.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("30", "Besa la palma de las manos de tu pareja y sube lentamente por sus brazos.", GameMood.ROMANTIC),

    // Escalation & Challenge (INTENSE & PLAYFUL)
    ActionCard("31", "Sopla suavemente aire cálido cerca del oído de tu pareja mientras acaricias su cintura.", GameMood.ROMANTIC),
    ActionCard("32", "Permite que tu pareja controle el ritmo de tus besos por los próximos 2 turnos.", GameMood.INTENSE),
    ActionCard("33", "Pregunta: ¿Qué posición o gesto te hace perder el control más rápido?", GameMood.INTENSE, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("34", "Acaricia el cabello de tu pareja mientras le das un beso largo y profundo.", GameMood.ROMANTIC),
    ActionCard("35", "Mueve tus caderas lentamente contra tu pareja durante 30 segundos.", GameMood.INTENSE),
    ActionCard("36", "Usa la yema de tus dedos para trazar figuras invisibles en el pecho de tu pareja e intente adivinarlas.", GameMood.PLAYFUL),
    ActionCard("37", "Pide un deseo íntimo que tu pareja deba concederte en los próximos 5 minutos.", GameMood.INTENSE),
    ActionCard("38", "Sujeta suavemente las muñecas de tu pareja por encima de su cabeza mientras le besas.", GameMood.INTENSE),
    ActionCard("39", "Pregunta: ¿Hay algún accesorio o ropa especial que te gustaría que usara?", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("40", "Dale a tu pareja un beso apasionado de 45 segundos sin pausar.", GameMood.ROMANTIC)
)
