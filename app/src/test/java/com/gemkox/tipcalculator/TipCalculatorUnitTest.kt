package com.gemkox.tipcalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat


class TipCalculatorUnitTest {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_20PercentRoundup(){
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, true)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_0PercentNoRoundup(){
        val amount = 10.00
        val tipPercent = 0.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(0)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_0_85PercentNoRoundup(){
        val amount = 50.00
        val tipPercent = 0.85
        val expectedTip = NumberFormat.getCurrencyInstance().format(0.43)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculateTip_0_85PercentRoundup(){
        val amount = 50.00
        val tipPercent = 0.85
        val expectedTip = NumberFormat.getCurrencyInstance().format(1)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, true)
        assertEquals(expectedTip, actualTip)
    }

}