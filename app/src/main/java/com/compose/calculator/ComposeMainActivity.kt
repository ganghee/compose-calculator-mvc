package com.compose.calculator

import android.os.Bundle
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.calculator.ui.theme.CalculatorTheme
import com.compose.calculator.ui.theme.Gray200

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
            text = statement,
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
                .padding(end = 60.dp),
            onClick = { /*TODO*/ },
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
            cells = GridCells.Fixed(4)
        ) {
            items(count = 16) { index ->
                when (index) {
                    0 -> CalculatorButton(
                        stringResource(R.string.calculator_7), Color.Black
                    ) {
                        statement = it
                    }
                    1 -> CalculatorButton(stringResource(R.string.calculator_8), Color.Black) {
                        statement = it
                    }
                    2 -> CalculatorButton(stringResource(R.string.calculator_9), Color.Black) {
                        statement = it
                    }
                    3 -> CalculatorButton(
                        stringResource(R.string.calculator_divide),
                        MaterialTheme.colors.primary
                    ) {
                        statement = it
                    }
                    4 -> CalculatorButton(stringResource(R.string.calculator_4), Color.Black) {
                        statement = it
                    }
                    5 -> CalculatorButton(stringResource(R.string.calculator_5), Color.Black) {
                        statement = it
                    }
                    6 -> CalculatorButton(stringResource(R.string.calculator_6), Color.Black) {
                        statement = it
                    }
                    7 -> CalculatorButton(
                        stringResource(R.string.calculator_multiply),
                        MaterialTheme.colors.primary
                    ) {
                        statement = it
                    }
                    8 -> CalculatorButton(stringResource(R.string.calculator_1), Color.Black) {
                        statement = it
                    }
                    9 -> CalculatorButton(stringResource(R.string.calculator_2), Color.Black) {
                        statement = it
                    }
                    10 -> CalculatorButton(stringResource(R.string.calculator_3), Color.Black) {
                        statement = it
                    }
                    11 -> CalculatorButton(
                        stringResource(R.string.calculator_minus),
                        MaterialTheme.colors.primary
                    ) {
                        statement = it
                    }
                    12 -> CalculatorButton(stringResource(R.string.calculator_0), Color.Black) {
                        statement = it
                    }
                    13 -> CalculatorButton("", MaterialTheme.colors.primary) {
                        statement = it
                    }
                    14 -> EqualButton()
                    15 -> CalculatorButton(
                        stringResource(R.string.calculator_plus),
                        MaterialTheme.colors.primary
                    ) {
                        statement = it
                    }
                }
            }
        }
    }
}

@Composable
fun EqualButton() {
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colors.primary),
        onClick = { /*TODO*/ },
    ) {
        Text(
            text = stringResource(id = R.string.calculator_equals),
            color = Color.White,
            fontSize = 28.sp
        )
    }
}

@Composable
fun CalculatorButton(text: String, color: Color, onClick: (String) -> Unit) {
    Text(
        modifier = Modifier
            .height(52.dp)
            .testTag("button$text")
            .clickable(
                onClick = { onClick(text) }
            ),
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
        color = color,
    )
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        CalculatorContainer()
    }
}