package com.example.easy_app

import android.os.Bundle
import android.util.Log
//import androidx.activity.ComponentActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.easy_app.ui.theme.Easy_APPTheme
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.size
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.remember

class MainActivity : AppCompatActivity() {

    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val imagePlay = findViewById<ImageView>(R.id.imagePlay)
        val imageStop = findViewById<ImageView>(R.id.imageStop)
        val textClicks = findViewById<TextView>(R.id.textClicks)

        imagePlay.setOnClickListener {
            clickCount++
            textClicks.text = "Clicks: $clickCount"
            Log.i("CountTAG", "count = $clickCount")

            // Скрываем Play, показываем Stop
            imagePlay.visibility = ImageView.GONE
            imageStop.visibility = ImageView.VISIBLE
        }

        imageStop.setOnClickListener {
            // Скрываем Stop, показываем Play
            imageStop.visibility = ImageView.GONE
            imagePlay.visibility = ImageView.VISIBLE
        }
    }
}
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Easy_APPTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    //
//    val clickCount = remember { mutableIntStateOf(0) }
//
//    Row(modifier = modifier) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_background),
//            contentDescription = "Standard Image",
//            modifier = Modifier
//                .size(64.dp)
//                .clickable {
//                    clickCount.intValue++  // увеличиваем счётчик
//                }
//        )
//        Column(modifier = Modifier.padding(start = 16.dp)) {
//            Text(text = "Hello $name", fontSize = 24.sp)
//            Text(text = "Nice to meet you", fontSize = 16.sp)
//            Text(text = "Clicks: ${clickCount.intValue}", fontSize = 16.sp)
//            Log.i("CountTAG", "count = ${clickCount.intValue}")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Easy_APPTheme {
//        Greeting("Android")
//    }
//}