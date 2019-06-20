package com.surya.moviekotlinmvp.model.response

import com.surya.moviekotlinmvp.model.Movie

data class MovieResponse(
    val results : List<Movie>
)