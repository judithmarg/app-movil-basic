package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.AppTheme
import com.example.network.CatResponseDto
import com.example.network.CataasRemoteDataSource
import com.example.network.RetrofitBuilder2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    val dataSource: CataasRemoteDataSource = CataasRemoteDataSource(RetrofitBuilder2)
    val context = LocalContext.current
    val cats = remember{ mutableStateOf<List<CatResponseDto>>(emptyList()) }
    LaunchedEffect(Unit){
        try{
            val response = dataSource.getCatResponse()
            cats.value=response

        }catch(e: Exception){
            Log.e("hola", "error")
        }
    }
    FlowRow(
        modifier=Modifier.fillMaxSize()
    ) {
        cats.value.forEach{
            cat ->
            Text(text = cat._id)
        }
    }
}
