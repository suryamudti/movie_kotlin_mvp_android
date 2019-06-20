package com.surya.moviekotlinmvp.model

import com.google.gson.annotations.SerializedName

data class Movie (
    val id: String,
    val title: String,
    val overview: String,

    @SerializedName("poster_path")
    var poster:String
)


