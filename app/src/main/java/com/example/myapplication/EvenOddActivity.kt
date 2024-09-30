package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.backgroundLight
import kotlin.random.Random

class EvenOddActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EvenOddUI(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun EvenOddUI(modifier: Modifier){
        var nCorrect by remember { mutableIntStateOf(0) }
        var nIncorrect by remember { mutableIntStateOf(0) }
        var randomNum by remember { mutableIntStateOf(Random.nextInt(1,20)) }

        Column (
            modifier = modifier.fillMaxSize()
        ){
            Box(modifier = Modifier.background(Color.Red)
                .fillMaxWidth(),){
                Text(modifier = Modifier.fillMaxWidth().height(60.dp),text = "Par-Impar", textAlign = TextAlign.Center)
            }
            Column(
                modifier = Modifier.background(backgroundLight)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Incorrectos: $nIncorrect")
                Text(text = "Correctos: $nCorrect")
                Text(text = "$randomNum", fontSize = 30.sp, modifier = Modifier.padding(50.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 100.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally)
            ){
                Button(modifier = Modifier.weight(1f), onClick = {
                    if(randomNum % 2 != 0){
                        nCorrect ++;
                    }else{
                        nIncorrect ++;
                    }
                    randomNum = Random.nextInt(1,20);
                }) {
                    Text(text = "IMPAR")
                }
                Button(modifier = Modifier.weight(1f), onClick = {
                    if(randomNum % 2 == 0){
                        nCorrect ++;
                    }else{
                        nIncorrect ++;
                    }
                    randomNum = Random.nextInt(1,20);
                }) {
                    Text(text = "PAR")
                }
            }
        }
    }

}