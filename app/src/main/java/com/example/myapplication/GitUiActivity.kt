package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.ui.theme.AppTheme
import com.example.network.GithubRemoteDataSource
import com.example.network.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GitUiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val context = applicationContext

        //val name = intent.extras?.getString("name")
        //Toast.makeText(context, name, Toast.LENGTH_LONG).show()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GitUi(modifier = Modifier.padding(innerPadding), context = context)
                }
            }
        }
    }
}

@Composable
fun GitUi(modifier: Modifier = Modifier, context:Context) {
    val dataSource: GithubRemoteDataSource = GithubRemoteDataSource(RetrofitBuilder)

    var urlImage by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }

    val list = UserRepository().getList()

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp, 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.github_ui_title)
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = userId, onValueChange = {
                userId = it
            })
        Button(onClick = {
            val show = Toast.makeText(context, userId, Toast.LENGTH_LONG).show()
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = dataSource.getAvatarInfo(userId)
                    withContext(Dispatchers.Main) {
                        urlImage = response.url
                        name = response.name?: "Without name"
                        company = response.company ?: "Without company"
                        bio = response.bio ?: "Without bio"
                    }
                }catch (e:Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "False", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }) {
            Text(text = stringResource(id = R.string.github_ui_button))
        }
        LazyRow {
            items(list.size){
                Button(onClick = {
                    userId = list[it].username
                }) {
                    Text(text = list[it].username)
                }
        }
            
        }
        
        AsyncImage(
            model = urlImage,
            contentDescription = null
        )
        Text(text = name)
        Text(text = company)
        Text(text = bio)
        }
    }

