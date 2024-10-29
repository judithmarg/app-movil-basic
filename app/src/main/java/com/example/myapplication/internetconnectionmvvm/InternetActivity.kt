package com.example.myapplication.internetconnectionmvvm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.example.myapplication.ui.theme.AppTheme

class InternetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                InternetUIContent()
            }
        }
    }
}
@Composable
fun InternetUIContent() {
//    var internetStatus by remember { mutableStateOf(false) }
    val localContext = LocalContext.current
    val localLifeCycleOwner = LocalLifecycleOwner.current
    val internetViewModel = InternetViewModel()
    fun updateUI(internetUIState: InternetViewModel.InternetUIState) {
        when( internetUIState) {
            is InternetViewModel.InternetUIState.Loading -> {
                Toast.makeText(localContext, "Cargando", Toast.LENGTH_LONG).show()
            }
            is InternetViewModel.InternetUIState.Connection -> {
                if (internetUIState.status) {
                    Toast.makeText(localContext, "Tiene acceso a internet", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(localContext, "No tiene acceso a internet", Toast.LENGTH_LONG)
                        .show()
                }
            }
            is InternetViewModel.InternetUIState.ErrorConnection -> {
                Toast.makeText(localContext, internetUIState.message, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
    internetViewModel.statusLiveData.observe(
        localLifeCycleOwner,
        Observer(::updateUI)
    )
    Scaffold {
            paddingValues -> Column(
        modifier = Modifier.padding(paddingValues).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            onClick = {
                internetViewModel.verify(localContext)
            }
        ) {
            Text(
                text = "Verify Internet Connection"
            )
        }
    }
    }
}