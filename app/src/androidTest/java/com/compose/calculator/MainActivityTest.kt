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

    @Test
    fun noOperand_input_showStatement() {
        //when: 사용자가 피연산자 1, +, 2를 누르면
        composeTestRule.onNodeWithTag("button1").performClick()
        composeTestRule.onNodeWithTag("button+").performClick()
        composeTestRule.onNodeWithTag("button2").performClick()

        //then: 계산기 텍스트에 '1 + 2'가 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("1 + 2")
    }

    @Test
    fun withOperand_inputOperand_addOperandNextToNumber() {
        //given: 숫자가 입력되었을 때
        composeTestRule.onNodeWithTag("button1").performClick()

        //when: 사용자가 피연산자 2를 누르면
        composeTestRule.onNodeWithTag("button2").performClick()

        //then: 계산기 텍스트에 '12'가 화면에 보여야 한다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("12")
    }

    @Test
    fun withoutOperand_inputOperator_showNothing() {
        // GIVEN - 아무것도 입력이 되어있지 않을 때

        // WHEN - 사용자가 +, -, *, / 를 누르면
        composeTestRule.onNodeWithTag("button+").performClick()

        // THEN - 입력이 되지 않는다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("0")
    }

    @Test
    fun withOperand_inputOperator_showStatement() {
        // GIVEN - 1이 입력되어 있을 때
        composeTestRule.onNodeWithTag("button1").performClick()

        // WHEN - 사용자가 +, -, *, / 를 누르면
        composeTestRule.onNodeWithTag("button+").performClick()

        // THEN - 해당 기호가 보인다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("1 +")
    }

    @Test
    fun inputNothing_clickDeleteButton_showNothing() {
        // GIVEN - 아무것도 입력이 되어있지 않을 때

        // WHEN - 사용자가 취소 버튼을 누르면
        composeTestRule.onNodeWithTag("buttonCancel").performClick()

        // THEN - 변화가 없다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("0")
    }

    @Test
    fun inputStatement_oneClickDeleteButton_deleteOperandOrOperator() {
        // GIVEN - 수식이 입력이 될 때
        composeTestRule.onNodeWithTag("button1").performClick()
        composeTestRule.onNodeWithTag("button+").performClick()
        composeTestRule.onNodeWithTag("button1").performClick()

        // WHEN - 사용자가 취소 버튼 한 번 누르면
        composeTestRule.onNodeWithTag("buttonCancel").performClick()

        // THEN - 기호삭제 및 숫자가 하나씩 제거 된다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("1 +")
    }

    @Test
    fun inputStatement_multiClickDeleteButton_deleteOperandOrOperator() {
        // GIVEN - 수식이 입력이 될 때
        composeTestRule.onNodeWithTag("button1").performClick()
        composeTestRule.onNodeWithTag("button+").performClick()
        composeTestRule.onNodeWithTag("button1").performClick()

        // WHEN - 사용자가 취소 버튼을 여러번 누르면
        composeTestRule.onNodeWithTag("buttonCancel").performClick()
        composeTestRule.onNodeWithTag("buttonCancel").performClick()

        // THEN - 기호삭제 및 숫자가 하나씩 제거 된다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("1")
    }

    @Test
    fun inputStatement_clickEqualButton_showResult() {
        // GIVEN - 수식이 입력이 될 때
        composeTestRule.onNodeWithTag("button1").performClick()
        composeTestRule.onNodeWithTag("button+").performClick()
        composeTestRule.onNodeWithTag("button1").performClick()

        // WHEN - 사용자가 결과 버튼을 누르면
        composeTestRule.onNodeWithTag("ButtonEqual").performClick()

        // THEN - 수식의 결과가 화면에 나온다.
        composeTestRule.onNodeWithTag("tag_statement").assertTextEquals("2")
    }

}