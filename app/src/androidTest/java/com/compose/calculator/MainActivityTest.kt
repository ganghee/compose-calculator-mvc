package com.compose.calculator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
@ExperimentalFoundationApi

class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeMainActivity>()

    @Test
    fun click0_show0() {
        //when: 사용자가 피연산자 0버튼을 누르면
        composeTestRule.onNodeWithTag("button0").performClick()

        //then: 계산기 텍스트에 0이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("0")
    }

    @Test
    fun click1_show() {
        //when: 사용자가 피연산자 1버튼을 누르면
        composeTestRule.onNodeWithTag("button1").performClick()

        //then: 계산기 텍스트에 1이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("1")
    }

    @Test
    fun click2_show2() {
        //when: 사용자가 피연산자 2버튼을 누르면
        composeTestRule.onNodeWithTag("button2").performClick()

        //then: 계산기 텍스트에 2이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("2")
    }

    @Test
    fun click3_show3() {
        //when: 사용자가 피연산자 3버튼을 누르면
        composeTestRule.onNodeWithTag("button3").performClick()

        //then: 계산기 텍스트에 3이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("3")
    }

    @Test
    fun click4_show4() {
        //when: 사용자가 피연산자 4버튼을 누르면
        composeTestRule.onNodeWithTag("button4").performClick()

        //then: 계산기 텍스트에 4이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("4")
    }

    @Test
    fun click5_show5() {
        //when: 사용자가 피연산자 5버튼을 누르면
        composeTestRule.onNodeWithTag("button5").performClick()

        //then: 계산기 텍스트에 5이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("5")
    }

    @Test
    fun click6_show6() {
        //when: 사용자가 피연산자 6버튼을 누르면
        composeTestRule.onNodeWithTag("button6").performClick()

        //then: 계산기 텍스트에 6이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("6")
    }

    @Test
    fun click7_show7() {
        //when: 사용자가 피연산자 7버튼을 누르면
        composeTestRule.onNodeWithTag("button7").performClick()

        //then: 계산기 텍스트에 7이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("7")
    }

    @Test
    fun click8_show8() {
        //when: 사용자가 피연산자 8버튼을 누르면
        composeTestRule.onNodeWithTag("button8").performClick()

        //then: 계산기 텍스트에 8이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("8")
    }

    @Test
    fun click9_show9() {
        //when: 사용자가 피연산자 9버튼을 누르면
        composeTestRule.onNodeWithTag("button9").performClick()

        //then: 계산기 텍스트에 9이 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("9")
    }
}