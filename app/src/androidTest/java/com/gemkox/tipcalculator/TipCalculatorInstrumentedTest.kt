package com.gemkox.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gemkox.tipcalculator.ui.theme.TipCalculatorTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.text.NumberFormat

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TipCalculatorInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.gemkox.tipcalculator", appContext.packageName)
    }

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists("No node with this text was found.")
    }

    @Test
    fun calculate_20_percent_tip_with_round() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip percentage").performTextInput("20")
        // Locate the Switch by its test tag and perform a click action
        composeTestRule.onNodeWithTag("roundUpSwitch").performClick()

        // Format the expected tip value
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        // Check if the node with the expected tip amount exists
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists("No node with this text was found.")
    }

}