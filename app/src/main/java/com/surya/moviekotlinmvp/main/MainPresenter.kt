package com.surya.moviekotlinmvp.main

import com.google.gson.Gson
import com.surya.moviekotlinmvp.model.Movie
import com.surya.moviekotlinmvp.model.response.MovieResponse
import com.surya.moviekotlinmvp.network.ApiRepository
import com.surya.moviekotlinmvp.network.MovieApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
        private val view: MainView,
        private val apiRepository: ApiRepository,
        private val gson: Gson
    ){

    fun getMovieList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(MovieApi.getMovie()), MovieResponse::class.java)

            uiThread {
                view.showMovieList(data.results)
            }
        }
    }

}