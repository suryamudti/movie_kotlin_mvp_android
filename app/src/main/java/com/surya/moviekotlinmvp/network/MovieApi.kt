package com.surya.moviekotlinmvp.network

import com.surya.moviekotlinmvp.BuildConfig.API_KEY
import com.surya.moviekotlinmvp.BuildConfig.BASE_URL

object MovieApi {

    fun getMovie():String{
        return BASE_URL + API_KEY
    }
}