package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AppTheme
import kotlinx.coroutines.launch

class VocabularyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ShowVocabulary(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                VocabularyWithSnackbar()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyWithSnackbar() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState()}
    val list = VocabularyRepository().getList()
    val context = LocalContext.current
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = Modifier.fillMaxSize()) { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(list.size){
                    ElevatedCard(onClick = {
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = list[it].description,
                                actionLabel = "Action",
                                duration = SnackbarDuration.Indefinite
                            )
                            when(result) {
                                SnackbarResult.ActionPerformed -> {}
                                SnackbarResult.Dismissed ->{}
                            }
                        }
                    },
                        modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = list[it].name,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center
                        )

                    }
                }
                }
            }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowVocabulary(modifier: Modifier) {
    val context = LocalContext.current
    val list = VocabularyRepository().getList()
    LazyColumn (
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(list.size){
            OutlinedCard(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                onClick = {
                    Toast.makeText(context, list[it].description, Toast.LENGTH_LONG).show()
                }) {
                Text(modifier = Modifier.padding(14.dp), text = list[it].name)
            }
        }
    }
}