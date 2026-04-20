package com.example.listfilm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listfilm.utils.FilmUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Hubungkan elemen UI dari layout XML
        val wadahListFilm = findViewById<LinearLayout>(R.id.wadahListFilm)
        val inputCari = findViewById<EditText>(R.id.inputCari)
        val btnCari = findViewById<Button>(R.id.btnCari)

        // 2. Logika Modul 4 & 5: Validasi Input (If-Else)
        btnCari.setOnClickListener {
            val query = inputCari.text.toString()

            if (query.isEmpty()) {
                // Jika kolom kosong, tampilkan peringatan merah dan Toast
                inputCari.error = "Kolom tidak boleh kosong!"
                Toast.makeText(this, "Tolong masukkan judul film", Toast.LENGTH_SHORT).show()
            } else {
                // Jika terisi (Logika pencariannya akan kita buat di Minggu 3)
                Log.d("42430058", "Tombol cari ditekan, mencari: $query")
                Toast.makeText(this, "Mencari: $query", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Ambil data dari array
        val filmList = FilmUtils.getFilmList()

        // 4. Looping data untuk memunculkan UI dan memasang Intent
        for (film in filmList) {

            // Mencetak desain kartu
            val viewKartu: View = LayoutInflater.from(this).inflate(R.layout.item_film, wadahListFilm, false)

            // Mengisi data teks ke dalam kartu
            val tvJudul = viewKartu.findViewById<TextView>(R.id.tvJudul)
            val tvGenre = viewKartu.findViewById<TextView>(R.id.tvGenre)
            val tvTahun = viewKartu.findViewById<TextView>(R.id.tvTahun)

            tvJudul.text = film.title
            tvGenre.text = "Genre: ${film.genre}"
            tvTahun.text = "Rilis: ${film.releaseYear}"

            // ==========================================
            // Logika Modul 4: Pindah Halaman (Intent)
            // ==========================================
            viewKartu.setOnClickListener {
                Log.d("42430058", "Kartu ${film.title} diklik!")

                val intent = Intent(this@MainActivity, DetailActivity::class.java)

                // Menitipkan data ke Intent (seperti membungkus paket)
                intent.putExtra("EXTRA_JUDUL", film.title)
                intent.putExtra("EXTRA_GENRE", film.genre)
                intent.putExtra("EXTRA_TAHUN", film.releaseYear)
                intent.putExtra("EXTRA_RATING", film.rating)
                intent.putExtra("EXTRA_SINOPSIS", film.synopsis)

                // Mulai pindah halaman
                startActivity(intent)
            }

            // Tempelkan kartu yang sudah jadi dan bisa diklik ke layar HP
            wadahListFilm.addView(viewKartu)
        }
    }
}