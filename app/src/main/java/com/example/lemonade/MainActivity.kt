package com.example.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonFunctionRunner()
        }
    }
}

fun imageClicked(step: Int) {
    Log.d("image Clicked", step.toString())
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

    var result = 1;

    val DataID =

    Column(
        modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(R.string.tree),
            modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontSize = 20.sp
        )
        Spacer(modifier.padding(20.dp))
        Image(
            painter = painterResource(id = R.drawable.lemon_1),
            contentDescription = stringResource(R.string.tree),
            modifier
                .clickable(onClick = { imageClicked(1) })
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .border(color = Color.Magenta, width = 4.dp)
        )
    }

}

