package com.surya.moviekotlinmvp.main

import com.surya.moviekotlinmvp.model.Movie

interface MainView {
    fun showMovieList(data: List<Movie>)
}