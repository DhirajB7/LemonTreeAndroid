package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.data.Lemon
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonFunctionRunner()
        }
    }
}

fun imageClicked(step: Int): Int {
    var stepNew = if (step == 2) {
        (5..10).random()
    } else {
        step
    }
    return when (stepNew) {
        1 -> 2
        3 -> 4
        4 -> 1
        7 -> 3
        else -> 2
    }

}

@Preview
@Composable
fun LemonFunctionRunner() {
    LemonadeTheme {
        LemonFunctionOnUI()
    }
}

@Composable
fun LemonFunctionOnUI(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }

    val data = when (result) {
        1 -> Lemon(1, R.string.lemon_1, R.drawable.lemon_1)
        2 -> Lemon(2, R.string.lemon_2, R.drawable.lemon_2)
        3 -> Lemon(3, R.string.lemon_3, R.drawable.lemon_3)
        4 -> Lemon(4, R.string.lemon_4, R.drawable.lemon_4)
        else -> Lemon(5, R.string.lemon_2, R.drawable.lemon_2)
    }

    Column(
        modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(data.lemonStringID),
            modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontSize = 20.sp
        )
        Spacer(modifier.padding(20.dp))
        Image(
            painter = painterResource(id = data.lemonDrawableId),
            contentDescription = stringResource(data.lemonStringID),
            modifier
                .clickable(onClick = { result = imageClicked(data.id) })
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .border(color = Color.Magenta, width = 4.dp)
        )
    }

}

