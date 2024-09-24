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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AppTheme

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
    Column (modifier=modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Counter(modifier)
            Counter(modifier)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "RESET")
        }
    }
}

@Composable
fun Counter(modifier: Modifier) {
    Column (
        modifier = modifier
            .padding(10.dp)
            .width(IntrinsicSize.Max)
    ){
        Text(text = "Team A", textAlign = TextAlign.Center, modifier=Modifier.fillMaxWidth())
        Text(text = "0",
            textAlign = TextAlign.Center,
            fontSize = 80.sp,
            modifier=Modifier.fillMaxWidth().padding(vertical = 40.dp))
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
            Text(text = "+3 POINTS")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
            Text(text = "+2 POINTS")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
            Text(text = "FREE THROW")
        }
    }
}