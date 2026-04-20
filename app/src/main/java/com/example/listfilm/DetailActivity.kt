package com.example.listfilm

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Tangkap data dari Intent
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val genre = intent.getStringExtra("EXTRA_GENRE")
        val tahun = intent.getIntExtra("EXTRA_TAHUN", 0)
        val rating = intent.getDoubleExtra("EXTRA_RATING", 0.0)
        val sinopsis = intent.getStringExtra("EXTRA_SINOPSIS")

        // Pasang ke UI
        findViewById<TextView>(R.id.tvDetailJudul).text = judul
        findViewById<TextView>(R.id.tvDetailSub).text = "$genre • $tahun • ⭐$rating"
        findViewById<TextView>(R.id.tvDetailSinopsis).text = sinopsis
    }
}