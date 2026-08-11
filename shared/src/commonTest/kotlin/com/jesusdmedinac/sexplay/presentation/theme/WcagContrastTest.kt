package com.jesusdmedinac.sexplay.presentation.theme

import androidx.compose.ui.graphics.Color
import kotlin.math.pow
import kotlin.test.Test
import kotlin.test.assertTrue

class WcagContrastTest {

    private fun calculateLinearComponent(c: Float): Double {
        val cd = c.toDouble()
        return if (cd <= 0.04045) {
            cd / 12.92
        } else {
            ((cd + 0.055) / 1.055).pow(2.4)
        }
    }

    private fun calculateRelativeLuminance(color: Color): Double {
        val r = calculateLinearComponent(color.red)
        val g = calculateLinearComponent(color.green)
        val b = calculateLinearComponent(color.blue)
        return 0.2126 * r + 0.7152 * g + 0.0722 * b
    }

    private fun calculateContrastRatio(color1: Color, color2: Color): Double {
        val l1 = calculateRelativeLuminance(color1)
        val l2 = calculateRelativeLuminance(color2)
        val maxL = maxOf(l1, l2)
        val minL = minOf(l1, l2)
        return (maxL + 0.05) / (minL + 0.05)
    }

    @Test
    fun `Primary button contrast ratio satisfies WCAG 2_1 Level AA (ge 4_5 to 1)`() {
        val bg = NeonPinkPrimary
        val text = DarkOnPrimary
        val cr = calculateContrastRatio(bg, text)

        assertTrue(
            cr >= 4.5,
            "Primary button text contrast ratio is $cr, which is below WCAG 2.1 AA minimum 4.5:1"
        )
    }

    @Test
    fun `Safe word badge contrast ratio satisfies WCAG 2_1 Level AAA (ge 7_0 to 1)`() {
        val bg = DarkErrorContainer
        val text = HighLuminanceCrimson
        val cr = calculateContrastRatio(bg, text)

        assertTrue(
            cr >= 7.0,
            "Safe word badge contrast ratio is $cr, which is below WCAG 2.1 AAA minimum 7.0:1"
        )
    }

    @Test
    fun `Background to text contrast ratio satisfies WCAG 2_1 Level AAA (ge 7_0 to 1)`() {
        val bg = DeepPlumBackground
        val text = Color(0xFFF3E5F5) // onBackground
        val cr = calculateContrastRatio(bg, text)

        assertTrue(
            cr >= 7.0,
            "Main background contrast ratio is $cr, which is below WCAG 2.1 AAA minimum 7.0:1"
        )
    }
}
