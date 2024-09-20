package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AppTheme
import kotlinx.coroutines.launch

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val context = applicationContext
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                SnackbarExample()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    CardExample(modifier = Modifier.padding(innerPadding), context = context)
//                    ScrollExample(modifier = Modifier.padding(innerPadding))
//                    Vocabulary(modifier = Modifier.padding(innerPadding), context = context)
//                }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackbarExample() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState()}
    val context = LocalContext.current
    Scaffold (
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                ElevatedCard(onClick =  {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Snackbar",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Indefinite
                        )
                        when(result) {
                            SnackbarResult.ActionPerformed -> {
                                openSecondActivity(context)
                            }
                            SnackbarResult.Dismissed ->{}
                        }
                    }
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Elevated",
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center)
               }
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Vocabulary(modifier: Modifier, context: Context) {
    val cont = 100.dp
    val vocabulary = LinkedHashMap<String, String>()
    vocabulary["a position"] = "a job or a title"
    vocabulary["a candidate"] = "someone who is being considered for a job"
    vocabulary["human resources (HR)"] = "the department in a company that deals with hiring, training, and helping employees"
    vocabulary["an application"] = "a formal, written request for a job, usually a form"
    vocabulary["a résumé"] = "a written description of your educación, abilities, and jobs"
    vocabulary["a cover letter"] = "a letter you write that goes with you résumé, highlighting details about your work experience"
    vocabulary["a reference"] = "someone who knows you well and can write a letter about you"
    vocabulary["a skill"] = "an ability to do something well"

    Column(
        modifier = Modifier
            .padding(100.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        vocabulary.forEach{ entry ->
            OutlinedCard(
                onClick = {
                    Toast.makeText(context, entry.value, Toast.LENGTH_LONG).show()
                },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, Color.Black),
            ) {
                Text(
                    text = entry.key,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center)
            }
        }

//        Button(onClick = { openSecondActivity(context) }) {
//            Text(text = "click")
//        }
    }
}
fun openSecondActivity(context: Context) {
    val intent = Intent(
        context,
        GitUiActivity::class.java)
    intent.putExtra(
        "name",  "judith"
    )
    context.startActivity(intent)
}