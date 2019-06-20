package com.surya.moviekotlinmvp.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.google.gson.Gson
import com.surya.moviekotlinmvp.R
import com.surya.moviekotlinmvp.detail.MovieDetailActivity
import com.surya.moviekotlinmvp.model.Movie
import com.surya.moviekotlinmvp.network.ApiRepository
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(),MainView {

    private lateinit var recyclerlistMovie: RecyclerView
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var movies:MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout{
            lparams(width= matchParent, height= wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            recyclerlistMovie = recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = GridLayoutManager(ctx,2)

            }
        }

        adapter = MainAdapter(movies){
            startActivity<MovieDetailActivity>(
                "TITLE" to it.title,
                "POSTER" to it.poster,
                "OVERVIEW" to it.overview
            )
        }

        recyclerlistMovie.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovieList()


    }

    override fun showMovieList(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
