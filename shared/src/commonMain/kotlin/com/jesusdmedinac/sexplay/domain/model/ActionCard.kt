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
    val description: String = "Cúmplelo manteniendo el ritmo y la atención en tu pareja. Puedes pausar o ajustar la intensidad según lo acuerden.",
    val mood: GameMood = GameMood.ROMANTIC,
    val tags: Set<HardLimit> = emptySet()
)

val baseActionCards = listOf(
    // Warm-up & Sensorial (ROMANTIC)
    ActionCard("1", "Besa apasionadamente el cuello de tu pareja durante 30 segundos.", "Comienza con besos suaves detrás de la oreja y baja gradualmente hacia la clavícula manteniendo un ritmo constante.", GameMood.ROMANTIC, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("2", "Quítale una prenda a tu pareja usando solo tus dientes.", "Tu pareja debe permanecer inmóvil mientras tú usas únicamente tus labios y dientes para deslizar la prenda.", GameMood.PLAYFUL, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("3", "Susurra al oído de tu pareja qué es lo que más te excita de su cuerpo.", "Acércate muy cerca a su oído, sopla suavemente y susurra en voz muy baja la parte de su cuerpo que más te atrae.", GameMood.ROMANTIC),
    ActionCard("4", "Acaricia suavemente el interior de los muslos de tu pareja durante un minuto.", "Usa las yemas de tus dedos en un movimiento circular ascendente sin tocar directamente las zonas íntimas primarias.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("5", "Dale un masaje en los hombros a tu pareja por dos minutos.", "Aplica presión media en los trapecios y el cuello usando tus pulgares para relajar la tensión.", GameMood.ROMANTIC, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("6", "Besa la zona del cuerpo de tu pareja que creas que es la más sensible.", "Tómate tu tiempo para explorar y elegir ese punto único donde sabes que tu pareja responde con mayor intensidad.", GameMood.ROMANTIC, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("7", "Hazle a tu pareja tu mejor baile sensual en cámara por un minuto.", "Pon tu música favorita o mueve tu cuerpo lentamente frente a la cámara o de pie frente a tu pareja manteniendo contacto visual.", GameMood.PLAYFUL),
    ActionCard("8", "Pregunta: ¿Cuál es una fantasía que nunca me has contado?", "Ambos deben mantener una zona libre de juicios. Responde con honestidad y curiosidad.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("9", "Muestra en cámara un objeto o prenda que te gustaría usar juntos.", "Elige un accesorio, prenda o elemento de la habitación y explica cómo te gustaría incorporarlo hoy o en el futuro.", GameMood.ROMANTIC),
    ActionCard("10", "Usa un cubo de hielo para recorrer tu propio cuerpo en cámara.", "Pasa el hielo por tu cuello, pecho o abdomen mostrando las sensaciones térmicas a tu pareja.", GameMood.INTENSE, setOf(HardLimit.TEMPERATURE_PLAY)),
    
    // Teasing & Anticipation (ROMANTIC & PLAYFUL)
    ActionCard("11", "Susurra tres cosas sucias que quieras hacerle a tu pareja cuando se vean.", "Menciona tres detalles específicos y sensuales que planeas ejecutar en su próximo encuentro íntimo.", GameMood.INTENSE),
    ActionCard("12", "Lame tus propios labios mirándole fijamente a la cámara.", "Mantén la mirada profunda y lame lentamente tus labios transmitiendo el deseo de besar a tu pareja.", GameMood.ROMANTIC),
    ActionCard("13", "Mantén la mirada fija en tu pareja en cámara durante 30 segundos sin pestañear.", "Desactiva las distracciones y conecta intensamente a través de los ojos sin hablar ni reírte.", GameMood.ROMANTIC),
    ActionCard("14", "Pide a tu pareja que te dé una orden sencilla por audio/video y cúmplela.", "La orden debe ser clara, respetuosa y erótica (ej. cambiar de postura, susurrar algo o quitarse un accesorio).", GameMood.PLAYFUL),
    ActionCard("15", "Toca tu propio cuello a cámara muy lenta por 1 minuto imaginando que es tu pareja.", "Imaginar el tacto de tu pareja mientras acaricias suavemente tu garganta y clavícula.", GameMood.ROMANTIC),
    ActionCard("16", "Dale 5 besos a la pantalla imaginando a tu pareja.", "Presiona tus labios cerca de la lente imaginando la boca de tu pareja.", GameMood.ROMANTIC),
    ActionCard("17", "Envía una nota de voz o mensaje susurrando una fantasía.", "Graba una nota corta de voz usando tono muy bajo y grave susurrando un deseo sensual.", GameMood.ROMANTIC),
    ActionCard("18", "Pregunta: ¿Cuál fue el momento exacto en que te sentiste más atraído/a por mí?", "Recuerden la anécdota o primera mirada que desató la chispa entre ustedes.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("19", "Abraza a tu pareja por la espalda y dale pequeños mordiscos en la oreja.", "Envuelve con tus brazos su torso y muerde con extrema suavidad el lóbulo de su oreja.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("20", "Ajusta la cámara para mostrar una vista tentadora por 30 segundos.", "Encuadra la cámara en una perspectiva sensual y sugerente de tu cuerpo.", GameMood.INTENSE),

    // Intense & Direct Play (INTENSE)
    ActionCard("21", "Muerde suavemente tu labio inferior mientras miras la cámara intensamente.", "Una mueca provocativa manteniendo el contacto visual sostenido.", GameMood.INTENSE),
    ActionCard("22", "Elige una posición sensual para mantener en cámara durante 1 minuto.", "Adopta una pose sugerente y sostenla relajadamente durante 60 segundos.", GameMood.ROMANTIC),
    ActionCard("23", "Hazle cosquillas eróticas a tu pareja en las zonas más sensibles de su cuerpo.", "Usa la punta de tus dedos para recorrer zonas sensibles sin causar molestia.", GameMood.PLAYFUL, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("24", "Pregunta: Si pudieras cambiar una sola regla de esta noche, ¿cuál sería?", "Descubre qué límite o juego le gustaría flexibilizar a tu pareja.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("25", "Coloca tus manos en la cadera de tu pareja y pégala a ti durante 30 segundos.", "Siente la respiración y el calor corporal de tu pareja pegando sus caderas.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("26", "Describe paso a paso cómo le acariciarías en este momento.", "Narra en voz baja y detallada el recorrido que harías con tus manos por su cuerpo.", GameMood.INTENSE),
    ActionCard("27", "Quítate una prenda de vestir a elección de tu pareja frente a la cámara.", "Tu pareja elige cuál prenda debes quitarte y tú la retiras lentamente.", GameMood.PLAYFUL),
    ActionCard("28", "Toca tu propio cuerpo donde tu pareja te ordene durante 45 segundos.", "Sigue las instrucciones verbales de tu pareja para acariciarte.", GameMood.INTENSE),
    ActionCard("29", "Confiesa un lugar poco común en el que te gustaría tener un encuentro íntimo.", "Revela esa ubicación atrevida fuera de la habitación donde te gustaría estar con tu pareja.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("30", "Besa la palma de tus manos y envíale ese beso a la cámara.", "Un gesto sensual y cariñoso hacia la pantalla o tu pareja.", GameMood.ROMANTIC),

    // Escalation & Challenge (INTENSE & PLAYFUL)
    ActionCard("31", "Sopla suavemente al micrófono de tu cámara imaginando que es el oído de tu pareja.", "Produce una ráfaga de aire suave y rítmica cerca del micrófono.", GameMood.ROMANTIC),
    ActionCard("32", "Permite que tu pareja elija tus movimientos en los próximos 2 turnos.", "Tú pareja toma la iniciativa y decide cómo debes responder en los siguientes turnos.", GameMood.INTENSE),
    ActionCard("33", "Pregunta: ¿Qué posición o gesto te hace perder el control más rápido?", "Intercambien información valiosa sobre sus detonantes eróticos principales.", GameMood.INTENSE, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("34", "Acaricia tu cabello mientras le das una mirada profunda a tu pareja en pantalla.", "Pasa tus dedos por tu cabello con lentitud mientras mantienes la mirada erótica.", GameMood.ROMANTIC),
    ActionCard("35", "Mueve tus caderas lentamente frente a la cámara durante 30 segundos.", "Un movimiento de caderas circular y pausado a vista de tu pareja.", GameMood.INTENSE),
    ActionCard("36", "Usa la yema de tus dedos para trazar figuras en el aire y que tu pareja las adivine.", "Dibuja letras o símbolos en el aire o sobre su piel para adivinar el mensaje.", GameMood.PLAYFUL),
    ActionCard("37", "Pide un deseo íntimo a distancia que tu pareja deba concederte en los próximos 5 minutos.", "Expresa una petición sensual inmediata que tu pareja deba cumplir.", GameMood.INTENSE),
    ActionCard("38", "Sujeta suavemente las muñecas de tu pareja por encima de su cabeza.", "Mantén sus brazos en alto con firmeza y ternura sobre la almohada.", GameMood.INTENSE, setOf(HardLimit.PHYSICAL_CONTACT)),
    ActionCard("39", "Pregunta: ¿Hay algún accesorio o ropa especial que te gustaría que usara?", "Conversen sobre lencería, disfraces o accesorios que les gustaría incluir.", GameMood.PLAYFUL, setOf(HardLimit.PERSONAL_QUESTIONS)),
    ActionCard("40", "Dale a la cámara un beso apasionado de 45 segundos sin pausar.", "Simula un beso prolongado e intenso frente a la cámara.", GameMood.ROMANTIC)
)
