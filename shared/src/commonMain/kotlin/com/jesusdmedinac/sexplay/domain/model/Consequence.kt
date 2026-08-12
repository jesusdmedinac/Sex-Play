package com.jesusdmedinac.sexplay.domain.model

enum class IntensityLevel(val level: Int, val displayName: String) {
    LOW(1, "Juguetón & Sensorial"),
    MEDIUM(2, "Dominación & Control"),
    HIGH(3, "Control & Castidad"),
    EXTREME(4, "Línea del Tabú")
}

enum class ConsequenceType {
    REWARD, PUNISHMENT
}

sealed class Consequence(
    open val title: String,
    open val description: String,
    open val type: ConsequenceType,
    open val level: IntensityLevel
) {
    // Level 1: Low Intensity
    
    // Rewards
    data object SpaService : Consequence(
        title = "Servicio de spa completo",
        description = "El ganador recibe un masaje de cuerpo completo de 30 minutos con aceites, sin la obligación de devolver el favor.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    )

    data object EnvironmentControl : Consequence(
        title = "El control del ambiente",
        description = "Derecho a elegir la música, la iluminación y la posición durante el resto del encuentro.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    )

    data object HandsFreePass : Consequence(
        title = "Pase de 'Manos Libres'",
        description = "El ganador no puede usar sus propias manos para nada; el perdedor debe hacer todo el trabajo de estimulación.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    )

    data object RoyalBreakfast : Consequence(
        title = "Desayuno en la cama",
        description = "El perdedor debe preparar y servir el desayuno en la cama a gusto del ganador al día siguiente.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    )

    data object SensoryKissPass : Consequence(
        title = "Pase de besos ilimitados",
        description = "El ganador puede solicitar besos apasionados en cualquier zona del cuerpo durante las próximas 12 horas.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    )

    // Punishments
    data object DomesticServitude : Consequence(
        title = "Servidumbre doméstica",
        description = "El perdedor debe hacer una tarea mundana del hogar vistiendo solo ropa interior o un delantal.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    )

    data object MandatorySpectator : Consequence(
        title = "Espectador obligatorio",
        description = "El perdedor debe sentarse con las manos en la espalda y observar atentamente cómo el ganador se da placer a sí mismo durante 5 minutos.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    )

    data object TeasingWithoutContact : Consequence(
        title = "Teasing sin contacto",
        description = "El perdedor debe acariciar y besar el cuerpo del ganador manteniendo milímetros de distancia sin tocar zonas íntimas primarias.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    )

    data object FootMassageDuty : Consequence(
        title = "Masaje de pies obligatorio",
        description = "El perdedor debe darle un masaje relajante y sensual de pies de 15 minutos al ganador.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    )

    // Level 2: Medium Intensity

    // Rewards
    data object Ragdoll : Consequence(
        title = "Muñeco de trapo",
        description = "El ganador tiene derecho a colocar al perdedor en la posición que desee y usar su cuerpo libremente sin que el perdedor intente tomar la iniciativa.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    )

    data object DictatedWardrobe : Consequence(
        title = "Vestuario dictado",
        description = "El ganador elige exactamente qué ropa interior (o la ausencia de ella) debe usar el perdedor durante todo el día siguiente.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    )

    data object InterruptionWildcard : Consequence(
        title = "Comodín de interrupción",
        description = "El ganador obtiene un 'vale' para detener al perdedor justo al borde del orgasmo (edging) en su próximo encuentro sexual.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    )

    data object BlindfoldControl : Consequence(
        title = "Dominio a ciegas",
        description = "El ganador decide vendar los ojos del perdedor durante los próximos 30 minutos de juego o intimidad.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    )

    // Punishments
    data object SensoryDeprivation : Consequence(
        title = "Privación sensorial",
        description = "El perdedor debe pasar los siguientes 20 minutos con los ojos vendados y audífonos escuchando sonido envolvente sin moverse.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    )

    data object LightSpanking : Consequence(
        title = "Castigo físico ligero (Spanking)",
        description = "El perdedor recibe una cantidad predeterminada de azotes rítmicos en los glúteos como penalización consensuada.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    )

    data object SubmissionPosture : Consequence(
        title = "Postura de sumisión",
        description = "El perdedor debe arrodillarse al pie de la cama y pedir permiso formalmente antes de volver a tocar al ganador.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    )

    data object IcePenalization : Consequence(
        title = "Penalización con hielo",
        description = "El perdedor debe sostener un cubo de hielo en una zona sensible de su propia piel durante 1 minuto sin quejarse ni retirarlo.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    )

    // Level 3: High Intensity

    // Rewards
    data object MasterForADay : Consequence(
        title = "Amo/a por un día",
        description = "Durante las siguientes 24 horas, el ganador tiene control absoluto sobre las decisiones íntimas y de placer de la pareja.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    )

    data object PrivateExhibitionism : Consequence(
        title = "Exhibicionismo privado",
        description = "El ganador puede tomar fotografías o videos eróticos del perdedor en posiciones vulnerables bajo previo acuerdo y privacidad.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    )

    data object ForcedToyUsage : Consequence(
        title = "Uso de juguetes forzado",
        description = "El ganador decide qué juguete utilizar en el perdedor, a qué intensidad y por cuánto tiempo sostenido.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    )

    data object FullSubservience : Consequence(
        title = "Obediencia nocturna",
        description = "El ganador tiene la palabra final e inapelable en cada fantasía que se ejecute durante el resto de la noche.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    )

    // Punishments
    data object ExtendedOrgasmDenial : Consequence(
        title = "Negación del orgasmo extendida",
        description = "El perdedor tiene prohibido llegar al clímax esa noche. Debe esperar hasta que el ganador le otorgue permiso explícito en otra ocasión.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    )

    data object RuinedOrgasm : Consequence(
        title = "Orgasmo arruinado (Ruined Orgasm)",
        description = "Justo cuando el perdedor esté a punto de llegar al clímax en el próximo encuentro, el ganador detendrá toda estimulación de golpe.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    )

    data object TotalRestriction : Consequence(
        title = "Restricción total",
        description = "El perdedor es atado de manos y pies a la cama durante 15 minutos mientras el ganador lo observa sin tocarlo.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    )

    data object EdgeMarathon : Consequence(
        title = "Maratón de bordeadas (Edging)",
        description = "El perdedor debe ser llevado al punto máximo al borde del clímax 3 veces consecutivas antes de permitirle o negarle la liberación.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    )

    // Level 4: Extreme Intensity (Taboo)

    // Rewards
    data object PublicRemoteControl : Consequence(
        title = "Control remoto en público",
        description = "El ganador obtiene el control remoto de un juguete vibrador que el perdedor deberá llevar puesto en un espacio público o cita.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME
    )

    data object FreeUseRight : Consequence(
        title = "Derecho de objetificación (Free Use)",
        description = "El ganador obtiene un 'cupón de uso libre' para iniciar contacto sexual sin juego previo durante todo el fin de semana.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME
    )

    data object DarkFantasyConfession : Consequence(
        title = "Confesión de fantasía oscura",
        description = "El perdedor debe revelar su fantasía más oculta e inconfesable, y el ganador decidirá cómo o cuándo llevarla a la práctica.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME
    )

    // Punishments
    data object EroticHumiliation : Consequence(
        title = "Humillación erótica (Begging)",
        description = "El perdedor debe rogar de rodillas y verbalmente por su liberación utilizando frases de sumisión consensuadas.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME
    )

    data object OwnershipMark : Consequence(
        title = "Marca de propiedad",
        description = "El perdedor debe llevar una marca erótica visible (un chupetón o marca temporal) que lo identifique como sumiso.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME
    )

    data object PhysicalChastity : Consequence(
        title = "Castidad física",
        description = "El perdedor debe usar un dispositivo de castidad física y el ganador conservará la llave durante un periodo establecido.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME
    )
}

val allConsequences = listOf(
    Consequence.SpaService, Consequence.EnvironmentControl, Consequence.HandsFreePass, Consequence.RoyalBreakfast, Consequence.SensoryKissPass,
    Consequence.DomesticServitude, Consequence.MandatorySpectator, Consequence.TeasingWithoutContact, Consequence.FootMassageDuty,
    Consequence.Ragdoll, Consequence.DictatedWardrobe, Consequence.InterruptionWildcard, Consequence.BlindfoldControl,
    Consequence.SensoryDeprivation, Consequence.LightSpanking, Consequence.SubmissionPosture, Consequence.IcePenalization,
    Consequence.MasterForADay, Consequence.PrivateExhibitionism, Consequence.ForcedToyUsage, Consequence.FullSubservience,
    Consequence.ExtendedOrgasmDenial, Consequence.RuinedOrgasm, Consequence.TotalRestriction, Consequence.EdgeMarathon,
    Consequence.PublicRemoteControl, Consequence.FreeUseRight, Consequence.DarkFantasyConfession,
    Consequence.EroticHumiliation, Consequence.OwnershipMark, Consequence.PhysicalChastity
)
