package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AppTheme

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val context = applicationContext
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardExample(modifier = Modifier.padding(innerPadding), context = context)
//                    ScrollExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardExample(modifier: Modifier, context: Context) {
    val contextLocal = LocalContext.current
    Column (
        modifier = Modifier
    ) {
        Card {
            Text(text = "Hello Android Compose")
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp)
        ) {
            Text(text = "Card with Width and Height")
        }
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Card fill max width", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center)
        }

        ElevatedCard {
            Text(
                text = "Elevated",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center)

        }
        ElevatedCard( modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Elevated",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center)

        }

        OutlinedCard(
            onClick = {
                Toast.makeText(context, "Texto", Toast.LENGTH_LONG).show()
            },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier.size(width = 240.dp, height = 100.dp)
        ) {
            Text(
                text = "Outlined",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center)
        }

        Text(text = "Saved podcasts")
        OutlinedCard(
            onClick = {
                Toast.makeText(contextLocal, "Hola a todos soy un toast", Toast.LENGTH_SHORT).show()
            },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, Color.Gray),
            modifier = Modifier.size(width = 240.dp, height = 100.dp)
        ) {
            Text(text = "At peace")
        }

    }
}

@Composable
fun ScrollExample(modifier: Modifier){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState())
    ){
        repeat(100){
            Text(text = "Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}