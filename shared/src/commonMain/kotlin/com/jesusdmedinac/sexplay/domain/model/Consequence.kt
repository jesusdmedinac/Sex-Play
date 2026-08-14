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
    open val level: IntensityLevel,
    open val isRemote: Boolean = false
) {
    // Level 1: Low Intensity
    
    // Rewards
    data object SpaService : Consequence(
        title = "Servicio de spa completo",
        description = "El ganador recibe un masaje de cuerpo completo de 30 minutos con aceites, sin la obligación de devolver el favor.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    data object EnvironmentControl : Consequence(
        title = "El control del ambiente",
        description = "Derecho a elegir la música, la iluminación y la dinámica durante el resto del encuentro.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW,
        isRemote = true
    )

    data object RemotePhotoSession : Consequence(
        title = "Sesión de fotos privada a la orden",
        description = "El perdedor debe tomarse y enviar 3 fotos sensuales siguiendo exactamente las indicaciones de ángulo y pose del ganador.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW,
        isRemote = true
    )

    data object HandsFreePass : Consequence(
        title = "Pase de 'Manos Libres'",
        description = "El ganador no puede usar sus propias manos para nada; el perdedor debe hacer todo el trabajo de estimulación.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    data object RoyalBreakfast : Consequence(
        title = "Desayuno en la cama",
        description = "El perdedor debe preparar y servir el desayuno en la cama a gusto del ganador al día siguiente.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    data object SensoryKissPass : Consequence(
        title = "Pase de besos ilimitados",
        description = "El ganador puede solicitar besos apasionados en cualquier zona del cuerpo durante las próximas 12 horas.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    // Punishments
    data object DomesticServitude : Consequence(
        title = "Servidumbre doméstica",
        description = "El perdedor debe hacer una tarea mundana del hogar vistiendo solo ropa interior o un delantal.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    data object EroticAudioNote : Consequence(
        title = "Nota de voz explícita",
        description = "El perdedor debe grabar y enviar un audio susurrado de 1 minuto describiendo detalladamente una fantasía con el ganador.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW,
        isRemote = true
    )

    data object MandatorySpectator : Consequence(
        title = "Espectador obligatorio",
        description = "El perdedor debe sentarse con las manos en la espalda y observar atentamente cómo el ganador se da placer a sí mismo durante 5 minutos.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW,
        isRemote = true
    )

    data object TeasingWithoutContact : Consequence(
        title = "Teasing sin contacto",
        description = "El perdedor debe acariciar y besar el cuerpo del ganador manteniendo milímetros de distancia sin tocar zonas íntimas primarias.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    data object FootMassageDuty : Consequence(
        title = "Masaje de pies obligatorio",
        description = "El perdedor debe darle un masaje relajante y sensual de pies de 15 minutos al ganador.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW,
        isRemote = false
    )

    // Level 2: Medium Intensity

    // Rewards
    data object Ragdoll : Consequence(
        title = "Muñeco de trapo",
        description = "El ganador tiene derecho a colocar al perdedor en la posición que desee y usar su cuerpo libremente sin que el perdedor intente tomar la iniciativa.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM,
        isRemote = false
    )

    data object DictatedWardrobe : Consequence(
        title = "Vestuario dictado",
        description = "El ganador elige exactamente qué ropa interior (o la ausencia de ella) debe usar el perdedor durante todo el día siguiente o durante la llamada.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    data object AppToyControl : Consequence(
        title = "Control de juguete por app",
        description = "El ganador tiene el control total de la vibración o intensidad del juguete a distancia durante la sesión.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    data object InterruptionWildcard : Consequence(
        title = "Comodín de interrupción",
        description = "El ganador obtiene un 'vale' para detener al perdedor justo al borde del orgasmo (edging) en su próximo encuentro.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    data object BlindfoldControl : Consequence(
        title = "Dominio a ciegas",
        description = "El ganador decide vendar los ojos del perdedor durante los próximos 30 minutos de juego o intimidad.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM,
        isRemote = false
    )

    // Punishments
    data object SensoryDeprivation : Consequence(
        title = "Privación sensorial",
        description = "El perdedor debe pasar los siguientes 20 minutos con los ojos vendados y audífonos escuchando sonido envolvente sin moverse.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    data object CameraStripTease : Consequence(
        title = "Striptease en cámara",
        description = "El perdedor debe realizar un striptease lento frente a la cámara al ritmo de la música elegida por el ganador.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    data object LightSpanking : Consequence(
        title = "Castigo físico ligero (Spanking)",
        description = "El perdedor recibe una cantidad predeterminada de azotes rítmicos en los glúteos como penalización consensuada.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM,
        isRemote = false
    )

    data object SubmissionPosture : Consequence(
        title = "Postura de sumisión",
        description = "El perdedor debe arrodillarse frente a la cámara y pedir permiso formalmente antes de continuar.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    data object IcePenalization : Consequence(
        title = "Penalización con hielo",
        description = "El perdedor debe sostener un cubo de hielo en una zona sensible de su propia piel durante 1 minuto sin quejarse ni retirarlo en cámara.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM,
        isRemote = true
    )

    // Level 3: High Intensity

    // Rewards
    data object MasterForADay : Consequence(
        title = "Amo/a por un día",
        description = "Durante las siguientes 24 horas, el ganador tiene control absoluto sobre las decisiones íntimas y de placer de la pareja.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    data object PrivateExhibitionism : Consequence(
        title = "Exhibicionismo privado",
        description = "El perdedor debe enviar un video erótico privado en poses vulnerables bajo previo acuerdo y privacidad.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    data object ForcedToyUsage : Consequence(
        title = "Uso de juguetes forzado",
        description = "El ganador decide qué juguete utilizar en el perdedor, a qué intensidad y por cuánto tiempo sostenido.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    data object FullSubservience : Consequence(
        title = "Obediencia nocturna",
        description = "El ganador tiene la palabra final e inapelable en cada fantasía que se ejecute durante el resto de la noche.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    // Punishments
    data object ExtendedOrgasmDenial : Consequence(
        title = "Negación del orgasmo extendida",
        description = "El perdedor tiene prohibido llegar al clímax esa noche. Debe esperar hasta que el ganador le otorgue permiso explícito.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    data object RuinedOrgasm : Consequence(
        title = "Orgasmo arruinado (Ruined Orgasm)",
        description = "Justo cuando el perdedor esté a punto de llegar al clímax en la videollamada o encuentro, el ganador detendrá toda estimulación de golpe.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    data object TotalRestriction : Consequence(
        title = "Restricción total",
        description = "El perdedor es atado de manos y pies a la cama durante 15 minutos mientras el ganador lo observa sin tocarlo.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH,
        isRemote = false
    )

    data object EdgeMarathon : Consequence(
        title = "Maratón de bordeadas (Edging)",
        description = "El perdedor debe ser llevado al punto máximo al borde del clímax 3 veces consecutivas antes de permitirle o negarle la liberación.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH,
        isRemote = true
    )

    // Level 4: Extreme Intensity (Taboo)

    // Rewards
    data object PublicRemoteControl : Consequence(
        title = "Control remoto en público",
        description = "El ganador obtiene el control remoto de un juguete vibrador que el perdedor deberá llevar puesto en un espacio público o cita.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME,
        isRemote = true
    )

    data object FreeUseRight : Consequence(
        title = "Derecho de objetificación (Free Use)",
        description = "El ganador obtiene un 'cupón de uso libre' para iniciar contacto sexual sin juego previo durante todo el fin de semana.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME,
        isRemote = false
    )

    data object DarkFantasyConfession : Consequence(
        title = "Confesión de fantasía oscura",
        description = "El perdedor debe revelar su fantasía más oculta e inconfesable por mensaje de voz o llamada, y el ganador decidirá cómo llevarla a la práctica.",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME,
        isRemote = true
    )

    // Punishments
    data object EroticHumiliation : Consequence(
        title = "Humillación erótica (Begging)",
        description = "El perdedor debe rogar de rodillas frente a la cámara por su liberación utilizando frases de sumisión consensuadas.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME,
        isRemote = true
    )

    data object OwnershipMark : Consequence(
        title = "Marca de propiedad",
        description = "El perdedor debe llevar una marca erótica visible (un chupetón o marca temporal) que lo identifique como sumiso.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME,
        isRemote = false
    )

    data object PhysicalChastity : Consequence(
        title = "Castidad física",
        description = "El perdedor debe usar un dispositivo de castidad física y el ganador conservará la llave o código durante un periodo establecido.",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME,
        isRemote = true
    )
}

val allConsequences = listOf(
    Consequence.SpaService, Consequence.EnvironmentControl, Consequence.RemotePhotoSession, Consequence.HandsFreePass, Consequence.RoyalBreakfast, Consequence.SensoryKissPass,
    Consequence.DomesticServitude, Consequence.EroticAudioNote, Consequence.MandatorySpectator, Consequence.TeasingWithoutContact, Consequence.FootMassageDuty,
    Consequence.Ragdoll, Consequence.DictatedWardrobe, Consequence.AppToyControl, Consequence.InterruptionWildcard, Consequence.BlindfoldControl,
    Consequence.SensoryDeprivation, Consequence.CameraStripTease, Consequence.LightSpanking, Consequence.SubmissionPosture, Consequence.IcePenalization,
    Consequence.MasterForADay, Consequence.PrivateExhibitionism, Consequence.ForcedToyUsage, Consequence.FullSubservience,
    Consequence.ExtendedOrgasmDenial, Consequence.RuinedOrgasm, Consequence.TotalRestriction, Consequence.EdgeMarathon,
    Consequence.PublicRemoteControl, Consequence.FreeUseRight, Consequence.DarkFantasyConfession,
    Consequence.EroticHumiliation, Consequence.OwnershipMark, Consequence.PhysicalChastity
)

