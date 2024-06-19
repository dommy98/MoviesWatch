package com.dominic.movieswatch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dominic.movieswatch.databinding.ActivityMainBinding
import com.dominic.movieswatch.ui.HomePage


class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val main = findViewById<View>(R.id.main)
        Log.d("MainActivity", "onCreate called")

        main?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }


    findViewById<Button>(R.id.btn_watch_now)?.setOnClickListener {

            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
}
