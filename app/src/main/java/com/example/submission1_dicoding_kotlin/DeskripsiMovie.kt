package com.example.submission1_dicoding_kotlin

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text


class DeskripsiMovie : AppCompatActivity() {
    companion object{
        const val  DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deskripsi_movie)

         val txtTitle:TextView = findViewById(R.id.tv_title_received)
         val txtDesc:TextView = findViewById(R.id.tv_description_received)
         val imagePoster : ImageView =findViewById(R.id.poster_image_received)
         val imageBackdrop :ImageView = findViewById(R.id.backdrop_image_received)

         val data = intent.getParcelableExtra(DATA) as Movie

        txtTitle.text = data.name
        txtDesc.text = data.desc
        imagePoster.setImageResource(data.photo)
        imageBackdrop.setImageResource(data.backdrop)

    }
}
