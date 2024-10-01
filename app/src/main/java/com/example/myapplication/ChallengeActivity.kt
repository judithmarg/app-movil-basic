package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.onPrimaryLight
import com.example.myapplication.ui.theme.primaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.primaryLight

class ChallengeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                CardGuide()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardGuide() {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = topAppBarColors(
                    containerColor = primaryContainerLightMediumContrast,
                    titleContentColor = onPrimaryLight),
                title = {
                    Box(modifier = Modifier.fillMaxWidth()){
                        Text(text = "Guide 9")
                    }
                }
            )
        }
    ){
        innerPaddingValues ->
        Column (
            modifier = Modifier.padding(innerPaddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Card (
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp)
            ){
                Row (modifier = Modifier.padding(vertical = 15.dp, horizontal = 5.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "7:24 PM - 8:00 PM")
                    Text(text = "36 min")
                }
                Row(modifier = Modifier.padding(horizontal = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)){
                    Box(modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 6.dp)
                        .size(35.dp)
                        .clip(CircleShape)
                        .background(primaryLight)
                    ){
                        Text(
                            text = "6",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White
                        )
                    }
                    Text(text = "<")
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "")
                }
                Column (
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = "7:26 PD from 96 St")
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp))
                    Text(text = "13 min")
                }
            }
        }
    }
}