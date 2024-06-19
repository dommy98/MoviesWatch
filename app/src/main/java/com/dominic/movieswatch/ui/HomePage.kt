package com.dominic.movieswatch.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.dominic.movieswatch.R
import com.dominic.movieswatch.adapter.MovieAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_home)

        // Apply padding for system bars (if needed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("MainActivity", "done")

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_search -> {
                    // Handle search action
                    true
                }
                R.id.navigation_my_library -> {
                    // Handle profile action
                    true
                }
                else -> false
            }
        }
        Log.d("MainActivity", "not called")
        // Example: Handle click on back button to go back to MainActivity
        findViewById<ImageView>(R.id.btn_back_to_main).setOnClickListener {
            onBackPressed()
        }

        // Find TabLayout and ViewPager2 by ID
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        // Initialize ViewPager2 with MovieAdapter
        val movieAdapter =MovieAdapter(this)
        viewPager.adapter = movieAdapter

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Now Playing"
                1 -> "Popular"
                2 -> "Top Rated"
                3 -> "Upcoming"
                else -> ""
            }
        }.attach()
    }
}