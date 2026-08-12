# Especificación y Catálogo de Diseños por Pantalla — Sex Play

Este documento contiene la especificación detallada de interfaz y experiencia de usuario para cada una de las 10 pantallas del proyecto **Sex Play (Adult Couples Card Game)**, diseñadas en **Google Stitch** (`StitchMCP`) bajo el sistema de diseño **Eros & Ember (Material 3 Expressive)**.

---

## 🎨 Sistema de Diseño Global: *Eros & Ember*

* **ID de Proyecto Stitch:** `5643953407614369854`
* **Asset de Sistema de Diseño:** `assets/e8a5425cd6784e22b05dbb22541d8a30`
* **Estilo Visual:** *Sensual Dark & Material 3 Expressive*
* **Paleta de Colores Base:**
  * **Background:** Deep Plum (`#16081A`)
  * **Primary:** Neon Pink (`#EC407A`) — Texto sobre primario: `#18040C` (WCAG 2.1 AA)
  * **Secondary:** Rose Gold (`#FFB74D`)
  * **Tertiary:** Emerald Green (`#63DF73`) — Container: `#21A643`
  * **Error / Safety:** Crimson Carmín (`#FF8099`) — Container: `#2D080D` (WCAG 2.1 AAA)
  * **Capas de Contenedores de Superficie:**
    1. `SurfaceContainerLowest`: `#17091B`
    2. `SurfaceContainerLow`: `#251629`
    3. `SurfaceContainer`: `#25102A`
    4. `SurfaceContainerHigh`: `#342438`
    5. `SurfaceContainerHighest`: `#402F43`
* **Trío Tipográfico:**
  * **Titulares (`Headline`):** `Sora` (Bold 700 / ExtraBold 800)
  * **Cuerpo (`Body`):** `Inter` (Regular 400 / Medium 500)
  * **Etiquetas (`Label`):** `Space Grotesk` (Bold 700, `letter-spacing: 0.1em`)
* **Geometría de Componentes:**
  * **Tarjetas Asimétricas:** Radio de esquinas alternado (`topStart: 32px`, `topEnd: 12px`, `bottomEnd: 32px`, `bottomStart: 12px`).
  * **Botones Expresivos:** Formas elípticas pill totalmente redondeadas (`24px` / `9999px`).

---

## 📑 Índice de Pantallas Diseñadas

1. [Pantalla 1: Nombres de los Jugadores (`SetupStep1NamesScreen`)](#pantalla-1-nombres-de-los-jugadores-setupstep1namesscreen)
2. [Pantalla 2: Ubicación / Presencial vs Remoto (`SetupStep2LocationScreen`)](#pantalla-2-ubicación--presencial-vs-remoto-setupstep2locationscreen)
3. [Pantalla 3: Duración y Modo de Juego (`SetupStep3DurationScreen`)](#pantalla-3-duración-y-modo-de-juego-setupstep3durationscreen)
4. [Pantalla 4: Ambiente y Vibe (`SetupStep4MoodScreen`)](#pantalla-4-ambiente-y-vibe-setupstep4moodscreen)
5. [Pantalla 5: Nivel de Intensidad Máximo (`SetupStep5IntensityScreen`)](#pantalla-5-nivel-de-intensidad-máximo-setupstep5intensityscreen)
6. [Pantalla 6: Límites Duros y Consentimiento (`SetupStep6LimitsScreen`)](#pantalla-6-límites-duros-y-consentimiento-setupstep6limitsscreen)
7. [Pantalla 7: Palabra de Seguridad (`SetupStep7SafeWordScreen`)](#pantalla-7-palabra-de-seguridad-setupstep7safewordscreen)
8. [Pantalla 8: Pantalla Principal de Juego (`GameScreen`)](#pantalla-8-pantalla-principal-de-juego-gamescreen)
9. [Pantalla 9: Selección de Consecuencia / Elección del Ganador (`WinnerChoiceScreen`)](#pantalla-9-selección-de-consecuencia--elección-del-ganador-winnerchoicescreen)
10. [Pantalla 10: Resolución Final y Estadísticas (`ResolutionScreen`)](#pantalla-10-resolución-final-y-estadísticas-resolutionscreen)

---

### Pantalla 1: Nombres de los Jugadores (`SetupStep1NamesScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/04b50425af9f48bf9e3e1fcd1ab06c12`
* **Título en Stitch:** `Player Names Setup`
* **Objetivo:** Registro inicial de los nombres de la pareja para personalizar la narrativa de las cartas y turnos.
* **Detalles del Diseño Visual:**
  * **Encabezado:** Titular *"¿Cómo se llaman?"* en tipografía `Sora` ExtraBold sobre fondo Deep Plum (`#16081A`).
  * **Campos de Entrada:** Dos contenedores minimalistas con estilo `surfaceContainerLow` (`#251629`), línea inferior de enfoque en Rosa Neón (`#EC407A`) y etiquetas `"Jugador 1"` y `"Jugador 2"`.
  * **Acciones:** Botón elíptico Rosa Neón Primario `"Siguiente"` en la parte inferior.
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 1 (`OutlinedTextField`).

---

### Pantalla 2: Ubicación / Presencial vs Remoto (`SetupStep2LocationScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/92aadd28343648c881f6e9ae22a98e06`
* **Título en Stitch:** `Location Setup`
* **Objetivo:** Definir la modalidad de juego (mismo dispositivo presencial vs remoto).
* **Detalles del Diseño Visual:**
  * **Encabezado:** Titular *"¿Dónde van a jugar hoy?"* en `Sora` Bold.
  * **Tarjetas de Selección M3 Expressive:**
    * Opción 1: *"En Persona (Mismo Dispositivo)"* — Subtexto explicativo de experiencia hotseat.
    * Opción 2: *"Modo a Distancia / Remoto"* — Subtexto de juego sincrónico sin contacto físico.
  * **Estados de Selección:** Transición tónica con *color morphing* hacia fondo Rosa Neón Primario y texto en negro profundo `#18040C`.
  * **Navegación:** Botón delineado `"Atrás"` + Botón elíptico Rosa Neón `"Siguiente"`.
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 2 (`ExpressiveOptionCard`).

---

### Pantalla 3: Duración y Modo de Juego (`SetupStep3DurationScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/1424f2f944304d31ba15b53e9f946c9b`
* **Título en Stitch:** `Duration Setup`
* **Objetivo:** Elegir la longitud de la partida (Express, Estándar o Maratón).
* **Detalles del Diseño Visual:**
  * **Encabezado:** Titular *"¿Cuánto tiempo tienen?"*.
  * **Tres Tarjetas Asimétricas de Selección:**
    1. *Modo Express (10 cartas)*: Subtexto *"Partida rápida e intensa (15-30 min)"*.
    2. *Modo Estándar (20 cartas)*: Subtexto *"La experiencia completa equilibrada (45-60 min)"*.
    3. *Modo Maratón (Sin límite)*: Subtexto *"Juego continuo hasta que uno ceda (90+ min)"*.
  * **Estilo Visual:** Esquinas redondeadas asimétricas `32px` / `12px` con compresión al tacto (`scale 0.98f`).
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 3.

---

### Pantalla 4: Ambiente y Vibe (`SetupStep4MoodScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/875a930a3c004834b16ab89eb216722c`
* **Título en Stitch:** `Mood Setup`
* **Objetivo:** Filtrar el tipo de retos según el tono emocional deseado para la sesión.
* **Detalles del Diseño Visual:**
  * **Encabezado & Subtítulo:** Titular *"¿Qué ambiente prefieren hoy?"* con guía *"Seleccionen el ambiente que mejor se adapte a su deseo actual"*.
  * **Cuatro Opciones de Ambiente:**
    1. *Romántico y Sensual* (Masajes, miradas, seducción suave).
    2. *Divertido y Coqueto* (Risas, caricias, verdad o reto ligero).
    3. *Intenso y Atrevido* (Dominación, mordiscos, dinámicas de poder).
    4. *Mixto / Sorpresa* (Combinación equilibrada de todos los ambientes).
  * **Feedback Táctil:** Tarjetas no seleccionadas en `surfaceContainerLow` (`#1B0A20`) y seleccionadas en Rosa Neón radiante.
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 4.

---

### Pantalla 5: Nivel de Intensidad Máximo (`SetupStep5IntensityScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/f18059ff32ed4991a98a6b54459abb5e`
* **Título en Stitch:** `Intensity Level Setup`
* **Objetivo:** Establecer la cota máxima de intensidad alcanzable durante la partida.
* **Detalles del Diseño Visual:**
  * **Encabezado:** Titular *"¿Nivel máximo de castigo?"*.
  * **Cuatro Niveles de Intensidad:**
    * *Nivel 1: Juguetón y Sensorial* (Exploración sutil).
    * *Nivel 2: Dominación y Control* (Dinámicas de poder moderadas).
    * *Nivel 3: Control y Castidad* (Enfoque en restricción y resistencia).
    * *Nivel 4: Línea del Tabú* (Exploración profunda de límites).
  * **Geometría & Animación:** Geometría asimétrica M3 con elevación dinámica de superficie.
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 5.

---

### Pantalla 6: Límites Duros y Consentimiento (`SetupStep6LimitsScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/2f604055923e498bae8da34c4e8ab38f`
* **Título en Stitch:** `Hard Limits & Consent Setup`
* **Objetivo:** Excluir explícitamente categorías de contenido no deseadas (Consentimiento Activo).
* **Detalles del Diseño Visual:**
  * **Encabezado:** Titular *"¿Límites a excluir?"* con subtítulo `(Opcional)`.
  * **Lista de Exclusión Multiselección M3:**
    * *Juegos de Temperatura* (Hielo, cera tibia, cambios térmicos).
    * *Juegos de Impacto* (Azotes ligeros, palmaditas).
    * *Preguntas Personales* (Confesiones profundas / privacidad).
  * **Indicador Seleccionado:** Icono Checkmark con borde luminoso y acento Rosa Neón.
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 6.

---

### Pantalla 7: Palabra de Seguridad (`SetupStep7SafeWordScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/7be84c8651954f93bb644e02f9ac8992`
* **Título en Stitch:** `Palabra de Seguridad`
* **Objetivo:** Confirmar la palabra clave de interrupción inmediata de la partida.
* **Detalles del Diseño Visual:**
  * **Encabezado:** Titular *"Palabra de Seguridad"*.
  * **Insignia de Seguridad Carmesí (`#FF8099`):** Tarjeta destacada de alto contraste: *"La seguridad es lo primero. Establezcan una palabra para pausar o detener el juego en cualquier momento"*. Cumple norma WCAG 2.1 AAA.
  * **Campo de Entrada:** Etiqueta *"Tu Palabra de Seguridad"* y sugerencia *"Ej. Rojo, Piña, Parar"*.
  * **Lanzamiento:** Botón elíptico principal en Rosa Neón `"¡Comenzar Partida!"`.
* **Componentes Compose Asociados:** `SetupWizardScreen.kt` -> Paso 7.

---

### Pantalla 8: Pantalla Principal de Juego (`GameScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/main_gameplay`
* **Título en Stitch:** `Gameplay`
* **Objetivo:** Pantalla principal de presentación de cartas de reto con física 3D.
* **Detalles del Diseño Visual:**
  * **HUD Superior de Estado:**
    * Badge de Seguridad Carmesí: `Palabra de Seguridad: Piña`.
    * Badge de Tensión Dinámico: `Tensión: Suave` (Verde Esmeralda `#63DF73`), `En Aumento` (Oro Rosa), `Alta Tensión` (Rosa Neón) o `Al Límite` (Carmesí).
  * **Turno:** Etiqueta en `Space Grotesk`: *"Turno de: Carlos"*.
  * **Carta Central de Acción M3:** Carta asimétrica de gran tamaño (`32px` / `12px`) con elevación de `16.dp` y animación de giro 3D con resortes elásticos.
  * **Acciones de Juego:** Botón primario `"Siguiente Turno"` + Botón secundario Carmesí `"¡Me rindo! (No aguanto más)"`.
* **Componentes Compose Asociados:** `GameScreen.kt`, `FlipCardContainer.kt`, `TensionProgressBar.kt`.

---

### Pantalla 9: Selección de Consecuencia / Elección del Ganador (`WinnerChoiceScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/ee685930e04f4bdb9a5993e40db72b61`
* **Título en Stitch:** `¡Juego Terminado!`
* **Objetivo:** Elección de premio o castigo tras finalizar la partida o rendición.
* **Detalles del Diseño Visual:**
  * **Encabezado Festivo:** Titular *"¡Juego Terminado!"* y *"¡Ana Gana!"* (o *"¡Completaron el juego juntos!"* en Verde Esmeralda `#63DF73` en caso de victoria compartida).
  * **Dos Botones Expresivos de Elección:**
    1. Botón elíptico Rosa Neón Primario: `"Recibir Premio"`.
    2. Botón delineado Carmesí: `"Aplicar Castigo"`.
* **Componentes Compose Asociados:** `EndGameScreen.kt` -> `WinnerChoiceScreen`.

---

### Pantalla 10: Resolución Final y Estadísticas (`ResolutionScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/9deb0aa7273d48508f16ce5cd607e3b3`
* **Título en Stitch:** `Premio para Ana`
* **Objetivo:** Desglose del premio/castigo seleccionado y panel de estadísticas de la sesión.
* **Detalles del Diseño Visual:**
  * **Tarjeta de Consecuencia M3:** Carta asimétrica interactiva. Para premios utiliza `tertiaryContainer` Verde Esmeralda (`#21A643`) y para castigos `errorContainer` Carmesí (`#2D080D`), con la etiqueta *"Toca para ver instrucciones completas"*.
  * **Panel de Estadísticas de Sesión:** Contenedor `surfaceContainerHigh` (`#342438`) que muestra:
    * *Cartas Jugadas:* Total acumulado en la sesión.
    * *Tiempo Juntos:* Duración en formato `MMm SSs`.
  * **Acción Final:** Botón elíptico Rosa Neón `"Jugar de Nuevo"`.
* **Componentes Compose Asociados:** `EndGameScreen.kt` -> `ResolutionScreen`.

---

## 🔍 Resumen de Mapeo de Archivos en el Código

| Pantalla | Archivo Kotlin en el Proyecto |
|---|---|
| 1 a 7 (Wizard Config) | [SetupWizardScreen.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/SetupWizardScreen.kt) |
| 8 (Gameplay) | [GameScreen.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/GameScreen.kt) |
| 9 y 10 (Resolución) | [EndGameScreen.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/EndGameScreen.kt) |
| Sistema de Tema | [SexPlayTheme.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/theme/SexPlayTheme.kt) |
| Barra de Tensión | [TensionProgressBar.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/components/TensionProgressBar.kt) |
| Tarjeta 3D Táctil | [FlipCardContainer.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/components/FlipCardContainer.kt) |
