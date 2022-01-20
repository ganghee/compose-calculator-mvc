package com.compose.calculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.compose.calculator.ui.theme.CalculatorTheme
import com.compose.calculator.ui.theme.Gray200
import com.compose.domain.Calculator

private val calculator = Calculator()

@ExperimentalFoundationApi
class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CalculatorContainer()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CalculatorContainer() {
    var statement by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 32.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .testTag(stringResource(R.string.tag_statement)),
            text = observeEmptyString(statement),
            textAlign = TextAlign.End,
            fontSize = 24.sp
        )
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = Gray200)
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        IconButton(
            modifier = Modifier
                .align(End)
                .padding(end = 60.dp)
                .testTag("buttonCancel"),
            onClick = {
                statement = deleteLastElement(statement)
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_backspace_24),
                contentDescription = null,
                tint = MaterialTheme.colors.primary
            )
        }
        Spacer(modifier = Modifier.height(height = 16.dp))
        LazyVerticalGrid(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 36.dp),
            cells = GridCells.Fixed(4),
        ) {
            items(count = 16) { index ->
                when (index) {
                    0 -> OperandButton(stringResource(R.string.calculator_7), statement) {
                        statement = it
                    }
                    1 -> OperandButton(stringResource(R.string.calculator_8), statement) {
                        statement = it
                    }
                    2 -> OperandButton(stringResource(R.string.calculator_9), statement) {
                        statement = it
                    }
                    3 -> OperatorButton(stringResource(R.string.calculator_divide), statement) {
                        statement = it
                    }
                    4 -> OperandButton(stringResource(R.string.calculator_4), statement) {
                        statement = it
                    }
                    5 -> OperandButton(stringResource(R.string.calculator_5), statement) {
                        statement = it
                    }
                    6 -> OperandButton(stringResource(R.string.calculator_6), statement) {
                        statement = it
                    }
                    7 -> OperatorButton(stringResource(R.string.calculator_multiply), statement) {
                        statement = it
                    }
                    8 -> OperandButton(stringResource(R.string.calculator_1), statement) {
                        statement = it
                    }
                    9 -> OperandButton(stringResource(R.string.calculator_2), statement) {
                        statement = it
                    }
                    10 -> OperandButton(stringResource(R.string.calculator_3), statement) {
                        statement = it
                    }
                    11 -> OperatorButton(stringResource(R.string.calculator_minus), statement) {
                        statement = it
                    }
                    12 -> OperandButton(stringResource(R.string.calculator_0), statement) {
                        statement = it
                    }
                    13 -> OperandButton("", statement) {
                        statement = it
                    }
                    14 -> EqualButton(LocalContext.current, statement) {
                        statement = it
                    }
                    15 -> OperatorButton(stringResource(R.string.calculator_plus), statement) {
                        statement = it
                    }
                }
            }
        }
    }
}

@Composable
fun EqualButton(context: Context, statement: String, onClick: (String) -> Unit) {
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colors.primary)
            .testTag("ButtonEqual"),
        onClick = {
            onClick(calculateStatement(context, statement))
        },
    ) {
        Text(
            text = stringResource(id = R.string.calculator_equals),
            color = Color.White,
            fontSize = 28.sp
        )
    }
}

@Composable
fun OperandButton(input: String, statement: String, onClick: (String) -> Unit) {
    Text(
        modifier = Modifier
            .height(52.dp)
            .testTag("button$input")
            .clickable(
                onClick = {
                    val updatedStatement = updateCalculateView(input, checkZeroState(statement))
                    onClick(updatedStatement)
                }
            ),
        text = input,
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
        color = Color.Black,
    )
}

@Composable
fun OperatorButton(input: String, statement: String, onClick: (String) -> Unit) {
    Text(
        modifier = Modifier
            .height(52.dp)
            .testTag("button$input")
            .clickable(
                onClick = {
                    val updatedStatement = checkWithOperand(checkZeroState(statement), input)
                    onClick(updatedStatement)
                }
            ),
        text = input,
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
        color = MaterialTheme.colors.primary,
    )
}

private fun checkWithOperand(statement: String, operator: String): String {
    return if (statement.isNotEmpty()) updateCalculateView(operator, statement)
    else ""
}

private fun checkZeroState(statement: String): String {
    return if (statement == "0") ""
    else statement
}

private fun updateCalculateView(input: String, statement: String): String {
    return statement.trim().addOperandToNumber(input)
}

private fun String.addOperandToNumber(input: String): String {
    val baseStatement = this@addOperandToNumber
    return if (baseStatement.isEmptyOrDigit(input)) {
        "$baseStatement$input"
    } else {
        "$baseStatement $input"
    }
}

private fun String.isEmptyOrDigit(input: String) = this.isEmpty() ||
        (this.last().isDigit() && input.isDigitsOnly())

private fun calculateStatement(context: Context, statement: String): String {
    var result = "0"
    runCatching {
        result = calculator.calculate(replaceOperator(statement)).toString()
    }.getOrElse { e ->
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }
    return result
}

private fun replaceOperator(statement: String): String {
    return statement
        .replace("÷", "/")
        .replace("×", "*")
}

private fun deleteLastElement(statement: String) = statement.dropLast(1).trim()

private fun observeEmptyString(statement: String?): String {
    return if (statement.isNullOrEmpty()) "0"
    else statement
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        CalculatorContainer()
    }
}