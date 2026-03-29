package com.example.easy_app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим View по ID
        val imagePlay = findViewById<ImageView>(R.id.imagePlay)
        val imageStop = findViewById<ImageView>(R.id.imageStop)
        val textClicks = findViewById<TextView>(R.id.textClicks)

        // Обработчик клика на Play
        imagePlay.setOnClickListener {
            clickCount++
            updateClicks<TextView>(textClicks, clickCount) // reified тип
            toggleVisibility(
                visibleView = imageStop,
                goneView = imagePlay,
                onVisible = { Log.i("MainActivity", "Stop button is now visible") },
                onGone = { Log.i("MainActivity", "Play button is now gone") }
            )
        }

        // Обработчик клика на Stop
        imageStop.setOnClickListener {
            toggleVisibility(
                visibleView = imagePlay,
                goneView = imageStop,
                onVisible = { Log.i("MainActivity", "Play button is now visible") },
                onGone = { Log.i("MainActivity", "Stop button is now gone") }
            )
        }
    }

    // ----------------------------
    // Reified + inline функция обновления текста
    // ----------------------------
    inline fun <reified T : TextView> updateClicks(view: T, count: Int) {
        view.text = "Clicks: $count"
    }

    // ----------------------------
    // Inline + crossinline + noinline функция toggle visibility
    // ----------------------------
    inline fun toggleVisibility(
        visibleView: View,
        goneView: View,
        crossinline onVisible: () -> Unit = {},
        noinline onGone: () -> Unit = {}
    ) {
        visibleView.visibility = View.VISIBLE
        goneView.visibility = View.GONE
        onVisible()
        onGone()
    }
}