package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.onPrimaryLight
import com.example.myapplication.ui.theme.secondaryContainerLight
import com.example.myapplication.ui.theme.tertiaryLight

class PracticingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MovieScreen(
                        name = "Interestelar",
                        image = "https://m.media-amazon.com/images/S/pv-target-images/79194981293eabf6620ece96eb5a9c1fffa04d3374ae12986e0748800b37b9cf.jpg",
                        subtitle = "2014 - Ciencia ficcion",
                        points = "8.1/10",
                        descrip = "Gracias a un descubrimiento, un grupo de cientificos y " +
                                "exploradores, encabezadis por Cooper, se embarcan en un viaje " +
                                "espacial para encontrar un lugar con las condiciones necesarias" +
                                "para reemplazar a la Tierra y comenzar una nueva vida alli.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MovieScreen(name: String, image: String, subtitle: String, points:String, descrip: String, modifier: Modifier = Modifier) {
    val movieImage = image
    var iconSelect by remember { mutableStateOf(false) }
    var rating by remember { mutableStateOf(0) }

    Box(modifier = modifier
        .padding(horizontal = 26.dp, vertical = 30.dp)
        .fillMaxSize()
        .clip(RoundedCornerShape(25.dp))){
    Column(
        modifier = Modifier
            .background(secondaryContainerLight)
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        AsyncImage(model = image, contentDescription = null, modifier= Modifier
            .height(340.dp)
            .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall
            )
            Button(onClick = { iconSelect = !iconSelect}) {
                Icon(
                    imageVector = if (iconSelect) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favoritos",
                    modifier = Modifier.size(34.dp),
                    tint = onPrimaryLight
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = subtitle,
            )
            Text(
                text = points,
                style = MaterialTheme.typography.titleLarge,
                color = tertiaryLight
            )
    }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RatingBar(
                rating = rating,
                onRatingChanged = { newRating ->
                    rating = newRating
                }
            )
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .padding(horizontal = 10.dp)) {
                Text(text = "Ver comentarios")
            }
        }

        Text(
            text = descrip,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Int = 0,
    onRatingChanged: (Int) -> Unit
) {
    var currentRating by remember { mutableStateOf(rating) }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= currentRating) {
                    Icons.Filled.Star
                } else {
                    Icons.Outlined.Star },
                contentDescription = "Rating",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        currentRating = i
                        onRatingChanged(i)
                    },
                tint = if (i <= currentRating) androidx.compose.ui.graphics.Color.Yellow else androidx.compose.ui.graphics.Color.Gray,
            )
        }
    }
}
