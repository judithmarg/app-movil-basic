package com.example.myapplication

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.primaryLight

class BackgroundColorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                backgroundUI()
            }
        }
    }
}

@Composable
fun backgroundUI() {
    var backgroundColor by remember{ mutableStateOf(Red) }

    Scaffold {
        paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor
        ){
            Column (
                modifier = Modifier.padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(onClick = {
                    backgroundColor = Blue
                }) {
                    Text(text = stringResource(id = R.string.btn_blue))
                }

                Button(onClick = {
                    backgroundColor = primaryLight
                }) {
                    Text(text = stringResource(id = R.string.btn_yellow))
                }
            }
        }
    }
}