package com.example.submission1_dicoding_kotlin

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        private lateinit var adapter: MovieAdapter
        private lateinit var dataName: Array<String>
        private lateinit var dataDesc: Array<String>
        private lateinit var dataRating:Array<String>
        private lateinit var dataPhoto: TypedArray
        private lateinit var dataBackdrop:TypedArray
        private var movies = arrayListOf<Movie>()

        const val DATA = "DATA"



    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview : ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listview.adapter = adapter

        prepare()
        addMovie()

        listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//            Toast.makeText(this@MainActivity, movies[position].name, Toast.LENGTH_SHORT).show()
             val intentWithExtraData = Intent(this@MainActivity,DeskripsiMovie::class.java)
                 intentWithExtraData.putExtra(DeskripsiMovie.DATA,movies[position])
                startActivity(intentWithExtraData)
        }
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.movie_name)
        dataDesc = resources.getStringArray(R.array.movie_desc)
        dataRating = resources.getStringArray(R.array.movie_rating)
        dataPhoto = resources.obtainTypedArray(R.array.movie_photo)
        dataBackdrop = resources.obtainTypedArray(R.array.movie_backdrop)
    }

    private fun addMovie(){
        for(position in dataName.indices){
            val movie = Movie(
                dataPhoto.getResourceId(position,-1),
                dataName[position],
                dataDesc[position],
                dataRating[position],
                dataBackdrop.getResourceId(position,-1)
            )
            movies.add(movie)

        }
        adapter.movies = movies
    }


}





