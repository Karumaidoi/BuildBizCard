package com.example.ktbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktbizcard.ui.theme.KtBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    createBizCard()
                }
            }
        }
    }
}

@Composable
fun createBizCard() {
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(15.dp)), backgroundColor = Color.White) {
            Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(modifier = Modifier.padding(4.dp))
                CreateInfo()
                Button(onClick = {
                    print("Something happened")
                }, modifier = Modifier.padding(vertical = 20.dp)) {
                    Text(text = "Portfolio")
                }
            }

        }
    }
}

@Preview
@Composable
fun content() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), shape = RoundedCornerShape(corner = CornerSize(6.dp)), border = BorderStroke(width = 2.dp, color = Color.LightGray)) {
            Portfolio(data = listOf("Project 1", "Project 2"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    //Equal to ListView Builder
    LazyColumn{
        items(data) {
            item ->  Text(item)
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(text = "Alex M.", style = MaterialTheme.typography.h4, color = MaterialTheme.colors.primaryVariant)
        Text(text = "Android Compose Programmer", style = TextStyle(color = Color.Black))
        Text(text = "@AlexMain436536", modifier = Modifier.padding(vertical = 4.dp))

    }
}

@Composable
private fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp), shape = CircleShape, border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp, color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.monster),
            contentDescription = "Monster Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )


    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KtBizCardTheme {
        createBizCard()
    }
}