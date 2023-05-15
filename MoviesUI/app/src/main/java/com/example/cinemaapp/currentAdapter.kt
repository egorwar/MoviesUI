package com.example.cinemaapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class currentAdapter(fragment: FragmentActivity, movies: List<Movie>) : FragmentStateAdapter(fragment) {
    val films = movies
    override fun getItemCount(): Int = films.size

    override fun createFragment(position: Int): Fragment {
        val film = films[position]
        return currentFragment.newInstance(film.title, film.image, film.rate, film.about)
    }
}