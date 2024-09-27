package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.myapplication.ui.theme.AppTheme

class BusinessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                businessUI()
            }
        }
    }

    @Composable
    fun businessUI() {
        var buttonName by remember { mutableStateOf("") }
        Scaffold (
            modifier = Modifier.fillMaxSize()
        ){
            paddingValues ->
            Column (
                modifier = Modifier.padding(paddingValues)
            ){
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.business_title))
                        Text(text = "Boton seleccionado")
                        Text(text = buttonName)
                    }
                }
                Box(modifier = Modifier.fillMaxWidth()) {
                    Column (
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val list = listOf(
                            "SERVICIOS",
                            "PORTAFOLIO",
                            "ACERCA DE",
                            "CONTACTO",
                            "REDES SOCIALES"
                        )
                        repeat(list.size) {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { buttonName = list[it] }
                            ) {
                                Text(text = list[it])    
                            }
                        }

                    }
                }
                
            }
        }
    }
}

