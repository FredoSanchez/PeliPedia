package com.mramirez.pelipedia

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewMAnager: RecyclerView.LayoutManager
    private var movieList : ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun initRecyclerView(){
        viewMAnager = LinearLayoutManager(this)

        movieAdapter = MovieAdapter(movieList)

        movie_list_rv.apply {
            setHasFixedSize(true)
            layoutManager  = viewMAnager
            adapter = movieAdapter
        }
    }


    fun addMovieToList(movie: Movie){
        movieList.add(movie)
        movieAdapter.changeList(movieList)
        Log.d("Number", movieList.size.toString())
    }

    private inner class FetchMovie : AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg params: String?): String {
            if (params.isNullOrEmpty()) return ""

            val movieName = params[0]
            /*
            val movieUrl = NetworkUtils()?.buildSearchUrl(movieName)

            return try {
                NetworkUtils().getResponseFromHttpUrl(movieUrl)
            } catch (e : IOException){
                ""
            }
            */
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }

}
