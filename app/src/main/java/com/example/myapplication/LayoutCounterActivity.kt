package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AppTheme

class LayoutCounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ordering(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Ordering(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }
    val basePrice = 100
    var price by remember { mutableIntStateOf(0) }
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "QUANTITY", modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp))
        Row (
            modifier = Modifier.padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = { count--; price = basePrice * count }) {
                Text(text = "-")
            }
            Text(text = count.toString(),
                    modifier = Modifier.padding(vertical = 0.dp, horizontal = 10.dp)
                )
            Button(onClick = { count++; price = basePrice * count }) {
                Text(text = "+")
            }
        }
        Text(text = "PRICE" )
        Text(text = "$ $price")
        Button(onClick = { /*TODO*/ },  modifier = Modifier.padding(15.dp)) {
            Text(text = "ORDER")
        }
    }
}
