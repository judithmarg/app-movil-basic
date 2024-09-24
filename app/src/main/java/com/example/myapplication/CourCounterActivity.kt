package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AppTheme
import kotlin.random.Random

class CourCounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterAll(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterAll(modifier: Modifier) {
    var numInitA by remember { mutableIntStateOf(0) }
    var numInitB by remember { mutableIntStateOf(0) }
    Column (modifier=modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Counter(modifier, numInitA, "Team A", onChange = {numInitA = it})
            Counter(modifier, numInitB, "Team B", onChange = {numInitB = it})
        }
        Button(onClick = { numInitA=0; numInitB=0 }) {
            Text(text = "RESET")
        }
    }
}

@Composable
fun Counter(modifier: Modifier, lastNumber: Int, teamName: String, onChange : (Int) -> Unit) {
    Column (
        modifier = modifier
            .padding(10.dp)
            .width(IntrinsicSize.Max)
    ){
        Text(text = teamName, textAlign = TextAlign.Center, modifier=Modifier.fillMaxWidth())
        Text(text = "$lastNumber",
            textAlign = TextAlign.Center,
            fontSize = 60.sp,
            modifier= Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp))
        Button(onClick = { onChange(lastNumber + 3) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
            Text(text = "+3 POINTS")
        }
        Button(onClick = { onChange(lastNumber + 2) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
            Text(text = "+2 POINTS")
        }
        Button(onClick = { onChange(lastNumber + Random.nextInt(0,20)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
            Text(text = "FREE THROW")
        }
    }
}