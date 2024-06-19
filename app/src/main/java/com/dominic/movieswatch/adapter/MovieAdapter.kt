package com.dominic.movieswatch.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.domflex.ui.PopularMoviesFragment

class MovieAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
         //   0 -> NowPlayingFragment()
            1 -> PopularMoviesFragment()
           // 2 -> TopRatedFragment()
           // 3 -> UpcomingMoviesFragment()
            else -> PopularMoviesFragment()
        }
    }
}
