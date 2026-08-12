# Screen Design Specifications & Catalog — Sex Play

This document contains the detailed user interface and user experience specification for each of the 10 screens in the **Sex Play (Adult Couples Card Game)** project, designed in **Google Stitch** (`StitchMCP`) under the **Eros & Ember (Material 3 Expressive)** design system.

---

## 🎨 Global Design System: *Eros & Ember*

* **Stitch Project ID:** `5643953407614369854`
* **Design System Asset ID:** `assets/e8a5425cd6784e22b05dbb22541d8a30`
* **Visual Style:** *Sensual Dark & Material 3 Expressive*
* **Base Color Palette:**
  * **Background:** Deep Plum (`#16081A`)
  * **Primary:** Neon Pink (`#EC407A`) — On-Primary text: `#18040C` (WCAG 2.1 AA)
  * **Secondary:** Rose Gold (`#FFB74D`)
  * **Tertiary:** Emerald Green (`#63DF73`) — Container: `#21A643`
  * **Error / Safety:** Crimson (`#FF8099`) — Container: `#2D080D` (WCAG 2.1 AAA)
  * **Surface Container Layers:**
    1. `SurfaceContainerLowest`: `#17091B`
    2. `SurfaceContainerLow`: `#251629`
    3. `SurfaceContainer`: `#25102A`
    4. `SurfaceContainerHigh`: `#342438`
    5. `SurfaceContainerHighest`: `#402F43`
* **Typography Scale:**
  * **Headlines:** `Sora` (Bold 700 / ExtraBold 800)
  * **Body Copy:** `Inter` (Regular 400 / Medium 500)
  * **Labels & Badges:** `Space Grotesk` (Bold 700, `letter-spacing: 0.1em`)
* **Component Geometry:**
  * **Asymmetric Cards:** Alternating corner radii (`topStart: 32px`, `topEnd: 12px`, `bottomEnd: 32px`, `bottomStart: 12px`).
  * **Expressive Buttons:** Fully rounded pill shapes (`24px` / `9999px`).

---

## 📑 Screen Index

1. [Screen 1: Player Names Setup (`SetupStep1NamesScreen`)](#screen-1-player-names-setup-setupstep1namesscreen)
2. [Screen 2: Location Setup / In-Person vs Remote (`SetupStep2LocationScreen`)](#screen-2-location-setup--in-person-vs-remote-setupstep2locationscreen)
3. [Screen 3: Duration & Game Mode Setup (`SetupStep3DurationScreen`)](#screen-3-duration--game-mode-setup-setupstep3durationscreen)
4. [Screen 4: Mood & Vibe Setup (`SetupStep4MoodScreen`)](#screen-4-mood--vibe-setup-setupstep4moodscreen)
5. [Screen 5: Maximum Intensity Level Setup (`SetupStep5IntensityScreen`)](#screen-5-maximum-intensity-level-setup-setupstep5intensityscreen)
6. [Screen 6: Hard Limits & Consent Setup (`SetupStep6LimitsScreen`)](#screen-6-hard-limits--consent-setup-setupstep6limitsscreen)
7. [Screen 7: Safe Word Setup (`SetupStep7SafeWordScreen`)](#screen-7-safe-word-setup-setupstep7safewordscreen)
8. [Screen 8: Main Gameplay Screen (`GameScreen`)](#screen-8-main-gameplay-screen-gamescreen)
9. [Screen 9: Winner Choice & Consequence Selection (`WinnerChoiceScreen`)](#screen-9-winner-choice--consequence-selection-winnerchoicescreen)
10. [Screen 10: Final Resolution & Session Statistics (`ResolutionScreen`)](#screen-10-final-resolution--session-statistics-resolutionscreen)

---

### Screen 1: Player Names Setup (`SetupStep1NamesScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/04b50425af9f48bf9e3e1fcd1ab06c12`
* **Stitch Title:** `Player Names Setup`
* **Objective:** Initial registration of player names to personalize the game narrative and turn markers.
* **Visual Design Details:**
  * **Header:** Title *"¿Cómo se llaman?"* in `Sora` ExtraBold typography on Deep Plum (`#16081A`) background.
  * **Input Fields:** Two minimalist containers styled with `surfaceContainerLow` (`#251629`), Neon Pink (`#EC407A`) focus line, labeled `"Player 1"` and `"Player 2"`.
  * **Actions:** Primary Neon Pink pill button `"Siguiente"` (Next) at the bottom.
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 1 (`OutlinedTextField`).

---

### Screen 2: Location Setup / In-Person vs Remote (`SetupStep2LocationScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/92aadd28343648c881f6e9ae22a98e06`
* **Stitch Title:** `Location Setup`
* **Objective:** Define game playability mode (single-device pass-and-play vs long-distance remote play).
* **Visual Design Details:**
  * **Header:** Title *"¿Dónde van a jugar hoy?"* in `Sora` Bold.
  * **M3 Expressive Selection Cards:**
    * Option 1: *"En Persona (Mismo Dispositivo)"* — Explanatory subtext for hotseat pass-and-play experience.
    * Option 2: *"Modo a Distancia / Remoto"* — Subtext for remote play excluding physical contact requirements.
  * **Selection States:** Color morphing transition into vibrant Neon Pink background with `#18040C` high-contrast bold text.
  * **Navigation:** Outlined `"Atrás"` (Back) button + Primary Neon Pink `"Siguiente"` pill button.
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 2 (`ExpressiveOptionCard`).

---

### Screen 3: Duration & Game Mode Setup (`SetupStep3DurationScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/1424f2f944304d31ba15b53e9f946c9b`
* **Stitch Title:** `Duration Setup`
* **Objective:** Choose session length and game mode (Express, Standard, or Marathon).
* **Visual Design Details:**
  * **Header:** Title *"¿Cuánto tiempo tienen?"*.
  * **Three Asymmetric Selection Cards:**
    1. *Modo Express (10 cartas)*: Subtext *"Partida rápida e intensa (15-30 min)"*.
    2. *Modo Estándar (20 cartas)*: Subtext *"La experiencia completa equilibrada (45-60 min)"*.
    3. *Modo Maratón (Sin límite)*: Subtext *"Juego continuo hasta que uno ceda (90+ min)"*.
  * **Visual Style:** Asymmetric corner radii `32px` / `12px` with tactile spring press scale (`0.98f`).
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 3.

---

### Screen 4: Mood & Vibe Setup (`SetupStep4MoodScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/875a930a3c004834b16ab89eb216722c`
* **Stitch Title:** `Mood Setup`
* **Objective:** Filter action cards according to the desired emotional tone for the session.
* **Visual Design Details:**
  * **Header & Subtitle:** Title *"¿Qué ambiente prefieren hoy?"* with guiding subtitle *"Seleccionen el ambiente que mejor se adapte a su deseo actual"*.
  * **Four Mood Selection Cards:**
    1. *Romántico y Sensual* (Massages, eye contact, gentle touch).
    2. *Divertido y Coqueto* (Laughter, playful dares, dancing).
    3. *Intenso y Atrevido* (Power dynamics, bites, deep erotic dares).
    4. *Mixto / Sorpresa* (Balanced combination of all moods).
  * **Tactile Feedback:** Unselected cards in `surfaceContainerLow` (`#1B0A20`), selected cards morphing to radiant Neon Pink.
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 4.

---

### Screen 5: Maximum Intensity Level Setup (`SetupStep5IntensityScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/f18059ff32ed4991a98a6b54459abb5e`
* **Stitch Title:** `Intensity Level Setup`
* **Objective:** Establish the maximum intensity boundary reachable during gameplay.
* **Visual Design Details:**
  * **Header:** Title *"¿Nivel máximo de castigo?"*.
  * **Four Intensity Levels:**
    * *Nivel 1: Juguetón y Sensorial* (Soft exploratory play).
    * *Nivel 2: Dominación y Control* (Moderate power dynamics).
    * *Nivel 3: Control y Castidad* (Focus on restraint and endurance).
    * *Nivel 4: Línea del Tabú* (Deep exploration of limits).
  * **Geometry & Animation:** M3 Asymmetric card geometry with dynamic surface elevation.
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 5.

---

### Screen 6: Hard Limits & Consent Setup (`SetupStep6LimitsScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/2f604055923e498bae8da34c4e8ab38f`
* **Stitch Title:** `Hard Limits & Consent Setup`
* **Objective:** Explicitly exclude unwanted activity categories (Active Consent Management).
* **Visual Design Details:**
  * **Header:** Title *"¿Límites a excluir?"* with subtitle `(Opcional)`.
  * **M3 Multi-Selection Exclusion List:**
    * *Juegos de Temperatura* (Ice, warm wax, thermal shifts).
    * *Juegos de Impacto* (Light spanking, taps).
    * *Preguntas Personales* (Deep confessions / privacy).
  * **Selection Indicator:** Checkmark icon with luminous border and Neon Pink accent.
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 6.

---

### Screen 7: Safe Word Setup (`SetupStep7SafeWordScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/7be84c8651954f93bb644e02f9ac8992`
* **Stitch Title:** `Palabra de Seguridad`
* **Objective:** Confirm the custom safe word for immediate game pause or termination.
* **Visual Design Details:**
  * **Header:** Title *"Palabra de Seguridad"*.
  * **Crimson Safety Badge (`#FF8099`):** High-contrast notice: *"La seguridad es lo primero. Establezcan una palabra para pausar o detener el juego en cualquier momento"*. Complies with WCAG 2.1 AAA standards.
  * **Input Field:** Label *"Tu Palabra de Seguridad"* and placeholder *"Ej. Rojo, Piña, Parar"*.
  * **Launch Action:** Large primary Neon Pink pill button `"¡Comenzar Partida!"`.
* **Associated Compose Components:** `SetupWizardScreen.kt` -> Step 7.

---

### Screen 8: Main Gameplay Screen (`GameScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/main_gameplay`
* **Stitch Title:** `Gameplay`
* **Objective:** Core gameplay screen presenting interactive 3D challenge cards.
* **Visual Design Details:**
  * **Top Status HUD:**
    * Crimson Safe Word Badge: `Palabra de Seguridad: Piña`.
    * Escalating Tension Badge: `Tensión: Suave` (Emerald Green `#63DF73`), `En Aumento` (Rose Gold), `Alta Tensión` (Neon Pink), or `Al Límite` (Crimson).
  * **Turn Label:** Styled in `Space Grotesk`: *"Turno de: Carlos"*.
  * **Central M3 Action Card:** Large asymmetric card (`32px` / `12px`) with `16.dp` elevation and 3D spring flip physics.
  * **Game Actions:** Primary button `"Siguiente Turno"` + Secondary Crimson button `"¡Me rindo! (No aguanto más)"`.
* **Associated Compose Components:** `GameScreen.kt`, `FlipCardContainer.kt`, `TensionProgressBar.kt`.

---

### Screen 9: Winner Choice & Consequence Selection (`WinnerChoiceScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/ee685930e04f4bdb9a5993e40db72b61`
* **Stitch Title:** `¡Juego Terminado!`
* **Objective:** Choose reward or punishment after game completion or surrender.
* **Visual Design Details:**
  * **Celebratory Header:** Title *"¡Juego Terminado!"* and *"¡Ana Gana!"* (or *"¡Completaron el juego juntos!"* in Emerald Green `#63DF73` for shared victory).
  * **Two Expressive Choice Buttons:**
    1. Primary Neon Pink pill button: `"Recibir Premio"`.
    2. Outlined Crimson button: `"Aplicar Castigo"`.
* **Associated Compose Components:** `EndGameScreen.kt` -> `WinnerChoiceScreen`.

---

### Screen 10: Final Resolution & Session Statistics (`ResolutionScreen`)

* **Stitch Resource Name:** `projects/5643953407614369854/screens/9deb0aa7273d48508f16ce5cd607e3b3`
* **Stitch Title:** `Premio para Ana`
* **Objective:** Display selected consequence details and session summary statistics.
* **Visual Design Details:**
  * **M3 Consequence Card:** Interactive asymmetric card. Uses Emerald Green `tertiaryContainer` (`#21A643`) for rewards and Crimson `errorContainer` (`#2D080D`) for punishments, with label *"Toca para ver instrucciones completas"*.
  * **Session Statistics Panel:** Tonal container `surfaceContainerHigh` (`#342438`) displaying:
    * *Cards Played:* Total turns completed in the session.
    * *Time Together:* Session duration formatted as `MMm SSs`.
  * **Final Action:** Primary Neon Pink pill button `"Jugar de Nuevo"`.
* **Associated Compose Components:** `EndGameScreen.kt` -> `ResolutionScreen`.

---

## 🔍 Code File Mapping Summary

| Screen | Kotlin Source File |
|---|---|
| 1 to 7 (Setup Wizard) | [SetupWizardScreen.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/SetupWizardScreen.kt) |
| 8 (Gameplay) | [GameScreen.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/GameScreen.kt) |
| 9 and 10 (Resolution) | [EndGameScreen.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/EndGameScreen.kt) |
| Theme System | [SexPlayTheme.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/theme/SexPlayTheme.kt) |
| Tension Tracker | [TensionProgressBar.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/components/TensionProgressBar.kt) |
| 3D Flip Card | [FlipCardContainer.kt](file:///Users/jesusdmedinac/proyectos/Sex%20Play%20Project/Sex%20Play/shared/src/commonMain/kotlin/com/jesusdmedinac/sexplay/presentation/ui/components/FlipCardContainer.kt) |
