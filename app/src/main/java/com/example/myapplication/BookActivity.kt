package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.data.Book
import com.example.data.BookRepository
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.onPrimaryLight
import com.example.myapplication.ui.theme.primaryLight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var listita by remember { mutableStateOf(emptyList<Book>()) }
    CoroutineScope(Dispatchers.IO).launch {
        val repository = BookRepository(context)
        repository.insert(Book("the best seller: Android"))
        val lista = repository.getListBooks()
        listita = lista
        lista.forEach{
            Log.d("DBTEST", "Id book = ${it.id}, Title: ${it.title}")
        }
    }

    LazyColumn(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 25.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listita.size) {
            OutlinedCard(modifier = Modifier.padding(5.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    modifier = Modifier
                        .background(primaryLight)
                        .padding(10.dp),
                    text = "Este ${listita[it].id} es el libro ${listita[it].title}",
                    color = onPrimaryLight
                )
            }
        }
    }
}
