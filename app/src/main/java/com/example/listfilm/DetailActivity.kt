package com.example.listfilm

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private val tagNIM = "42430058"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.d(tagNIM, "=== HALAMAN DETAIL DIBUKA ===")

        // Modul 9: Pengamanan ekstraks data Intent
        try {
            val judul = intent.getStringExtra("EXTRA_JUDUL") ?: "Judul Kosong"
            val genre = intent.getStringExtra("EXTRA_GENRE") ?: "Genre Kosong"
            val tahun = intent.getIntExtra("EXTRA_TAHUN", 0)
            val rating = intent.getDoubleExtra("EXTRA_RATING", 0.0)
            val sinopsis = intent.getStringExtra("EXTRA_SINOPSIS") ?: "Sinopsis Kosong"
            val poster = intent.getIntExtra("EXTRA_POSTER", 0)

            findViewById<TextView>(R.id.tvDetailJudul).text = judul
            findViewById<TextView>(R.id.tvDetailSub).text = "$genre • $tahun • ⭐$rating"
            findViewById<TextView>(R.id.tvDetailSinopsis).text = sinopsis

            val imgDetailPoster = findViewById<ImageView>(R.id.imgDetailPoster)
            if (poster != 0) {
                imgDetailPoster.setImageResource(poster)
            }

            Log.d(tagNIM, "Sukses menampilkan detail: $judul")

        } catch (e: Exception) {
            Log.e(tagNIM, "Error saat menampilkan detail: ${e.message}")
            Toast.makeText(this, "Gagal memuat informasi film", Toast.LENGTH_SHORT).show()
        }
    }
}