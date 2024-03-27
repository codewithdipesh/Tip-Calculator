package com.example
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.TipTimeLayout
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get: Rule
    val composTestRule = createComposeRule()

    @Test
    fun calculate_20_Percent_tip(){
        composTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        composTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text found"
        )
    }
}