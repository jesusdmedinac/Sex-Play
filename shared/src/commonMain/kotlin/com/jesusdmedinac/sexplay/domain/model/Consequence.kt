package com.jesusdmedinac.sexplay.domain.model

enum class IntensityLevel(val level: Int) {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    EXTREME(4)
}

enum class ConsequenceType {
    REWARD, PUNISHMENT
}

sealed class Consequence(
    open val title: String,
    open val type: ConsequenceType,
    open val level: IntensityLevel
) {
    // Level 1: Low Intensity
    
    // Rewards
    data object SpaService : Consequence(
        title = "Servicio de spa completo",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    ) // El ganador recibe un masaje de cuerpo completo de 30 minutos con aceites, sin la obligación de devolver el favor.

    data object EnvironmentControl : Consequence(
        title = "El control del ambiente",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    ) // Derecho a elegir la música, la iluminación y la posición durante el resto del encuentro.

    data object HandsFreePass : Consequence(
        title = "Pase de 'Manos Libres'",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    ) // El ganador no puede usar sus propias manos para nada; el perdedor debe hacer todo el trabajo.

    data object RoyalBreakfast : Consequence(
        title = "Desayuno en la cama",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    ) // El perdedor debe preparar y servir el desayuno en la cama al día siguiente.

    data object SensoryKissPass : Consequence(
        title = "Pase de besos ilimitados",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.LOW
    ) // El ganador puede solicitar besos en cualquier momento durante las próximas 12 horas.

    // Punishments
    data object DomesticServitude : Consequence(
        title = "Servidumbre doméstica",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    ) // El perdedor debe hacer una tarea mundana vistiendo solo ropa interior o un delantal.

    data object MandatorySpectator : Consequence(
        title = "Espectador obligatorio",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    ) // El perdedor debe sentarse con las manos atadas o en la espalda y observar cómo el ganador se da placer a sí mismo durante 5 minutos.

    data object TeasingWithoutContact : Consequence(
        title = "Teasing sin contacto",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    ) // El perdedor debe acariciar y besar el cuerpo del ganador sin tocar las zonas erógenas primarias durante un tiempo establecido.

    data object FootMassageDuty : Consequence(
        title = "Masaje de pies obligatorio",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.LOW
    ) // El perdedor debe darle un masaje relajante de pies de 15 minutos al ganador.

    // Level 2: Medium Intensity

    // Rewards
    data object Ragdoll : Consequence(
        title = "Muñeco de trapo",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    ) // El ganador tiene derecho a colocar al perdedor en la posición que desee y usar su cuerpo sin que el perdedor pueda moverse.

    data object DictatedWardrobe : Consequence(
        title = "Vestuario dictado",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    ) // El ganador elige exactamente qué ropa interior (o la ausencia de ella) debe usar el perdedor al día siguiente.

    data object InterruptionWildcard : Consequence(
        title = "Comodín de interrupción",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    ) // El ganador obtiene un 'vale' para detener al perdedor justo al borde del orgasmo en su próximo encuentro sexual.

    data object BlindfoldControl : Consequence(
        title = "Dominio a ciegas",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.MEDIUM
    ) // El ganador decide vendar los ojos del perdedor durante los próximos 30 minutos de juego o intimidad.

    // Punishments
    data object SensoryDeprivation : Consequence(
        title = "Privación sensorial",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    ) // El perdedor debe pasar los siguientes 20 minutos con los ojos vendados y audífonos con ruido blanco.

    data object LightSpanking : Consequence(
        title = "Castigo físico ligero (Spanking)",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    ) // El perdedor recibe una cantidad predeterminada de azotes en los muslos o glúteos como penalización.

    data object SubmissionPosture : Consequence(
        title = "Postura de sumisión",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    ) // El perdedor debe arrodillarse al pie de la cama y pedir permiso formalmente antes de volver a tocar al ganador.

    data object IcePenalization : Consequence(
        title = "Penalización con hielo",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.MEDIUM
    ) // El perdedor debe sostener un cubo de hielo en su piel sensible durante 1 minuto sin quejarse.

    // Level 3: High Intensity

    // Rewards
    data object MasterForADay : Consequence(
        title = "Amo/a por un día",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    ) // Durante las siguientes 24 horas, el ganador tiene control absoluto sobre las decisiones íntimas de la pareja.

    data object PrivateExhibitionism : Consequence(
        title = "Exhibicionismo privado",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    ) // El ganador puede grabar un video o tomar fotos del perdedor en posiciones vulnerables (bajo previo acuerdo).

    data object ForcedToyUsage : Consequence(
        title = "Uso de juguetes forzado",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    ) // El ganador decide qué juguete utilizar en el perdedor, a qué intensidad y por cuánto tiempo.

    data object FullSubservience : Consequence(
        title = "Obediencia nocturna",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.HIGH
    ) // El ganador tiene la palabra final en cada fantasía que se ejecute durante el resto de la noche.

    // Punishments
    data object ExtendedOrgasmDenial : Consequence(
        title = "Negación del orgasmo extendida",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    ) // El perdedor tiene prohibido llegar al clímax esa noche. Debe esperar hasta que el ganador le dé permiso.

    data object RuinedOrgasm : Consequence(
        title = "Orgasmo arruinado (Ruined Orgasm)",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    ) // Justo cuando el perdedor está a punto de llegar al clímax, el ganador detiene toda estimulación de golpe.

    data object TotalRestriction : Consequence(
        title = "Restricción total",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    ) // El perdedor es atado a la cama y abandonado en la habitación durante 15 minutos para reflexionar.

    data object EdgeMarathon : Consequence(
        title = "Maratón de bordeadas (Edging)",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.HIGH
    ) // El perdedor debe ser llevado al límite 3 veces consecutivas antes de que se le permita o niegue el final.

    // Level 4: Extreme Intensity (Taboo)

    // Rewards
    data object PublicRemoteControl : Consequence(
        title = "Control remoto en público",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME
    ) // El ganador obtiene el control de un juguete vibrador a distancia que el perdedor deberá llevar puesto en público.

    data object FreeUseRight : Consequence(
        title = "Derecho de objetificación (Free Use)",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME
    ) // El ganador obtiene un 'cupón de uso libre' para iniciar contacto sexual sin preliminares durante un fin de semana.

    data object DarkFantasyConfession : Consequence(
        title = "Confesión de fantasía oscura",
        type = ConsequenceType.REWARD,
        level = IntensityLevel.EXTREME
    ) // El perdedor debe revelar su fantasía más oculta, y el ganador decide si la actúan o se burlan eróticamente de ella.

    // Punishments
    data object EroticHumiliation : Consequence(
        title = "Humillación erótica (Begging)",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME
    ) // El perdedor debe rogar verbalmente por su orgasmo utilizando frases degradantes consensuadas.

    data object OwnershipMark : Consequence(
        title = "Marca de propiedad",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME
    ) // El perdedor debe llevar una marca visible (un chupetón o algo escrito con marcador) que lo identifique como 'perdedor'.

    data object PhysicalChastity : Consequence(
        title = "Castidad física",
        type = ConsequenceType.PUNISHMENT,
        level = IntensityLevel.EXTREME
    ) // El perdedor debe usar una jaula de castidad, y el ganador guarda la llave por un tiempo predeterminado.
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
