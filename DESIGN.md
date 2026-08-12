---
name: Eros & Ember
colors:
  surface: '#1c0e20'
  surface-dim: '#1c0e20'
  surface-bright: '#443348'
  surface-container-lowest: '#17091b'
  surface-container-low: '#251629'
  surface-container: '#25102A'
  surface-container-high: '#342438'
  surface-container-highest: '#402f43'
  on-surface: '#f4dbf5'
  on-surface-variant: '#e1bec4'
  inverse-surface: '#f4dbf5'
  inverse-on-surface: '#3b2b3f'
  outline: '#a8898e'
  outline-variant: '#594045'
  surface-tint: '#ffb1c2'
  primary: '#ffb1c2'
  on-primary: '#18040C'
  primary-container: '#fd4e87'
  on-primary-container: '#590025'
  inverse-primary: '#b80f55'
  secondary: '#ffb954'
  on-secondary: '#452b00'
  secondary-container: '#c3841b'
  on-secondary-container: '#3c2500'
  tertiary: '#63df73'
  on-tertiary: '#00390f'
  tertiary-container: '#21a643'
  on-tertiary-container: '#00320c'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#ffd9df'
  primary-fixed-dim: '#ffb1c2'
  on-primary-fixed: '#3f0018'
  on-primary-fixed-variant: '#8f003f'
  secondary-fixed: '#ffddb4'
  secondary-fixed-dim: '#ffb954'
  on-secondary-fixed: '#291800'
  on-secondary-fixed-variant: '#633f00'
  tertiary-fixed: '#80fc8c'
  tertiary-fixed-dim: '#63df73'
  on-tertiary-fixed: '#002106'
  on-tertiary-fixed-variant: '#00531a'
  background: '#1c0e20'
  on-background: '#f4dbf5'
  surface-variant: '#402f43'
  surface-lowest: '#110414'
  surface-low: '#1B0A20'
  surface-high: '#33163B'
  surface-highest: '#421C4D'
  error-crimson: '#FF8099'
typography:
  display-lg:
    fontFamily: Sora
    fontSize: 48px
    fontWeight: '800'
    lineHeight: 56px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Sora
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
  headline-lg-mobile:
    fontFamily: Sora
    fontSize: 28px
    fontWeight: '700'
    lineHeight: 36px
  title-md:
    fontFamily: Sora
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-lg:
    fontFamily: Space Grotesk
    fontSize: 14px
    fontWeight: '700'
    lineHeight: 20px
    letterSpacing: 0.1em
  label-md:
    fontFamily: Space Grotesk
    fontSize: 12px
    fontWeight: '600'
    lineHeight: 16px
    letterSpacing: 0.05em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  base: 8px
  xs: 4px
  sm: 12px
  md: 24px
  lg: 48px
  xl: 64px
  gutter: 16px
  margin-mobile: 20px
  margin-desktop: 120px
---

## Brand & Style

The design system is engineered to evoke an atmosphere of intimacy, luxury, and sophisticated play. It targets modern couples seeking an elevated, private experience that feels both provocative and high-end.

The aesthetic follows a **Sensual Dark & Material 3 Expressive** style. This approach leverages the structural logic of Google’s Material 3 but infuses it with high-contrast accents, deep-seated shadows, and unconventional geometry. The interface feels like a premium physical deck of cards resting on a velvet surface, utilizing multi-layered surface containers to create depth within a dark environment. Motion should be fluid and "weighted," emphasizing the physical nature of the cards through spring-based physics and tactile feedback.

## Colors

The palette is anchored by **Deep Plum (#16081A)**, providing a moody, immersive foundation that eliminates harsh glares during nighttime use. **Neon Pink (#EC407A)** serves as the primary energetic driver, representing passion and action, while **Rose Gold (#FFB74D)** adds a secondary layer of premium warmth and elegance.

Depth is achieved through a five-tier surface container system. Higher elevation corresponds to lighter, more saturated plum tones, creating a clear hierarchy for modal overlays and interactive cards. Text contrast must remain high; use `on-primary` for text atop Neon Pink elements to ensure maximum legibility against the vibrant hue.

## Typography

This design system utilizes a trio of typefaces to balance expression with clarity. **Sora** provides bold, geometric headlines that command attention and feel modernly luxurious. **Inter** is used for body copy to ensure effortless readability of card instructions, even in low-light settings. **Space Grotesk** is reserved for labels and status indicators, providing a technical, high-contrast edge that cuts through the more organic elements of the UI.

Maintain tight tracking for large display headers and increased letter-spacing for labels to reinforce the premium, editorial feel.

## Layout & Spacing

The layout is content-centric, prioritizing the "Card" as the primary unit of interaction. It uses a fluid grid system with generous internal padding to maintain a feeling of luxury and "breathing room."

- **Mobile:** 4-column grid with 20px side margins. Elements typically span the full width to maximize the touch area for card interaction.
- **Desktop/Tablet:** 12-column grid centered with 120px margins. Interactive cards should occupy the central 6-8 columns to maintain focus and intimacy.

Spacing follows an 8px base rhythm. Large vertical gaps (48px+) should be used between the headline and the main card area to emphasize the "staged" feel of the game's progression.

## Elevation & Depth

Elevation is primarily communicated through color shifting (Surface Container levels) rather than traditional drop shadows. However, to emphasize the premium "physical" nature of the game:

1.  **Backdrop Blurs:** Use high-density blurs (24px+) behind modal overlays to maintain the Deep Plum atmosphere while focusing on the foreground action.
2.  **Inner Glows:** Interactive cards should feature a subtle, 1px inner border in a low-opacity Rose Gold to simulate light catching the edge of a physical card.
3.  **Active State:** When a card is pressed, use a subtle "squeeze" scale (0.98) and increase the saturation of the primary glow to indicate tension.

## Shapes

The design system departs from standard symmetry to create a "distinctive edge." The primary **Asymmetric Card** geometry uses alternating large and small corner radii, creating a visual tension that reflects the game's themes. This shape must be applied to all primary action cards and main content containers.

Buttons follow the **Expressive Pill** style, utilizing full circular ends (24px minimum radius) to provide a soft, tactile contrast to the sharper, asymmetric cards. Selection indicators and secondary tags use a more standard 20px rounded corner.

## Components

- **Action Cards:** The centerpiece of the UI. These must use the asymmetric geometry. On interaction, they should utilize a 3D flip animation with spring physics (damping: 0.7, stiffness: 200).
- **Pill Buttons:** High-contrast buttons using the Primary Neon Pink. Labels should be centered, bold, and use the `label-lg` style.
- **Tension Indicators:** Use a progress-based badge system. As tension increases (Suave to Al Límite), the badge background should shift from Surface High to Primary Neon Pink with a pulsating "glow" animation.
- **Safe Word Badge:** A persistent, high-luminance crimson element that always remains at the highest elevation layer. It must pass AAA contrast standards with white text.
- **Input Fields:** Minimalist containers using `surface-low` with a Neon Pink bottom-border focus state.
- **Selection Cards:** For "Choose your path" moments, use 20px rounded cards that morph their background color to a semi-transparent Neon Pink when selected.