package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.remember
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeWithButtonAndImage(
                        "Lemonade",
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun LemonadeWithButtonAndImage(tittle: String, modifier: Modifier = Modifier) {
    var result by remember{ mutableStateOf(1) }
    val imageResource = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when(result){
        1 -> R.string.tap_lemon_tree
        2 -> R.string.keep_tapping_lemon
        3 -> R.string.tap_lemonade
        else -> R.string.tap_empty_glass
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .padding(8.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = tittle,
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }

        //Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier
                .background(Color.LightGray)
        ){
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button( onClick = {
                    result++
                    if(result>4) result=1
                },
                    modifier = Modifier.padding(64.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(256.dp)
                            .border(2.dp, Color(0xFF69CDD8), shape = RoundedCornerShape(64.dp))

                    ){
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = result.toString(),
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = RoundedCornerShape(8.dp))

                        )
                    }

                }

                Text(
                    text = stringResource(id = textResource),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeWithButtonAndImage("Lemonade", modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}