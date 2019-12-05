package com.example.submission1_dicoding_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView

class MovieAdapter internal  constructor(private val context: Context):BaseAdapter(){

    internal var movies = arrayListOf<Movie>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        var itemView = view
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val Movies = getItem(position) as Movie

        viewHolder.bind(Movies)

        return itemView
    }

    private inner class ViewHolder internal  constructor(view:View){
        private val txtName : TextView = view.findViewById(R.id.txt_name)
        private val txtDesc : TextView = view.findViewById(R.id.txt_description)
        private val txtRating: TextView = view.findViewById(R.id.txt_rating)
        private val imgPhoto : ImageView = view.findViewById(R.id.img_photo)


        internal fun bind(movie:Movie){
            txtName.text = movie.name
            txtDesc.text = movie.desc
            txtRating.text = movie.rating
            imgPhoto.setImageResource(movie.photo)
        }
    }

    override fun getItem(i: Int): Any {
        return movies[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

}

