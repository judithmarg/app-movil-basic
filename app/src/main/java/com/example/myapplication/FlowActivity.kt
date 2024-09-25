package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
class FlowActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    FlowFruits(
                    )
                }
            }
        }
    }

    @Composable
    private fun FlowRowSimpleUsageExample() {
        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 2
        ) {
            val itemModifier = Modifier
                .padding(4.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Red)
            repeat(6) { item ->
                if ((item + 1) % 3 == 0) {
                    Spacer(modifier = itemModifier.fillMaxWidth())
                } else {
                    Spacer(modifier = itemModifier.weight(0.5f))
                }
            }
        }
    }

    @Composable
    private fun FlowRowSimple(){
        val rows = 3
        val columns = 3
        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = rows
        ) {
            val itemModifier = Modifier
                .padding(4.dp)
                .height(80.dp)
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Blue)
            repeat(rows * columns) {
                Spacer(modifier = itemModifier)
            }
        }
    }

    @Composable
    private fun FlowFruits() {
        val listDesserts = listOf(
            "Apple", "Banana","Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb",
            "Ice Cream Sandwich", "Jellyfish","KiKat", "Lollipop","Marshmallow","Nougat"
        )
        FlowColumn(
            Modifier
                .padding(20.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachColumn = 7,
        ) {
            repeat(listDesserts.size) {
                Box(modifier = Modifier
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
                ){
                    Text(
                        text = listDesserts[it],
                        fontSize = 12.sp,
                        modifier = Modifier.padding(3.dp)
                        )
                }
            }
        }
    }
}

