package com.example.listfilm


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.listfilm.utils.FilmUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sengaja tidak memakai setContentView agar tidak memikirkan error UI dulu

        val filmList = FilmUtils.getFilmList()
        for (film in filmList) {
            Log.d("42430058", film.title)
        }
    }
}