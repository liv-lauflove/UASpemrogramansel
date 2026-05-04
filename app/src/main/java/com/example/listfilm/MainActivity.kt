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
import com.example.listfilm.models.Film

class MainActivity : AppCompatActivity() {

    private lateinit var wadahListFilm: LinearLayout
    private lateinit var dataFilmSemua: ArrayList<Film>
    private var dataSaatIni: ArrayList<Film> = ArrayList()

    // Tag Logcat Sesuai Syarat Dosen
    private val tagNIM = "42430058"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Merekam aktivitas awal aplikasi
        Log.d(tagNIM, "=== APLIKASI DIBUKA ===")

        wadahListFilm = findViewById(R.id.wadahListFilm)
        val inputCari = findViewById<EditText>(R.id.inputCari)
        val btnCari = findViewById<Button>(R.id.btnCari)
        val btnSortAZ = findViewById<Button>(R.id.btnSortAZ)
        val btnSortZA = findViewById<Button>(R.id.btnSortZA)

        // Modul 9: Try-Catch saat memuat data awal
        try {
            dataFilmSemua = FilmUtils.getFilmList()
            dataSaatIni.addAll(dataFilmSemua)
            tampilkanData(dataSaatIni)
            Log.d(tagNIM, "Berhasil memuat ${dataFilmSemua.size} data film.")
        } catch (e: Exception) {
            Log.e(tagNIM, "Error memuat data: ${e.message}")
        }
        // AKSI TOMBOL CARI
        btnCari.setOnClickListener {
            val keyword = inputCari.text.toString()
            Log.d(tagNIM, "Aktivitas: Tombol Cari ditekan. Kata kunci: '$keyword'")

            try {
                if (keyword.isEmpty()) {
                    inputCari.error = "Kolom tidak boleh kosong!"
                    dataSaatIni.clear()
                    dataSaatIni.addAll(dataFilmSemua)
                    tampilkanData(dataSaatIni)
                    Log.w(tagNIM, "Pencarian dibatalkan (Kolom kosong).")
                } else {
                    val hasilCari = linearSearch(keyword)
                    if (hasilCari.isEmpty()) {
                        Toast.makeText(this, "Film tidak ditemukan!", Toast.LENGTH_SHORT).show()
                    }
                    dataSaatIni = hasilCari
                    tampilkanData(dataSaatIni)
                    Log.d(tagNIM, "Hasil pencarian: Ditemukan ${hasilCari.size} film.")
                }
            } catch (e: Exception) {
                Log.e(tagNIM, "Terjadi error saat mencari: ${e.message}")
            }
        }

        // AKSI TOMBOL SORT A-Z
        btnSortAZ.setOnClickListener {
            try {
                Log.d(tagNIM, "Aktivitas: Mengurutkan data A - Z...")
                dataSaatIni = bubbleSort(dataSaatIni, isAscending = true)
                tampilkanData(dataSaatIni)
                Toast.makeText(this, "Diurutkan A - Z", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e(tagNIM, "Error saat mengurutkan: ${e.message}")
            }
        }

        // AKSI TOMBOL SORT Z-A
        btnSortZA.setOnClickListener {
            try {
                Log.d(tagNIM, "Aktivitas: Mengurutkan data Z - A...")
                dataSaatIni = bubbleSort(dataSaatIni, isAscending = false)
                tampilkanData(dataSaatIni)
                Toast.makeText(this, "Diurutkan Z - A", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e(tagNIM, "Error saat mengurutkan: ${e.message}")
            }
        }
    }

    private fun tampilkanData(listFilm: ArrayList<Film>) {
        wadahListFilm.removeAllViews()

        for (film in listFilm) {
            val viewKartu: View = LayoutInflater.from(this).inflate(R.layout.item_film, wadahListFilm, false)

            viewKartu.findViewById<TextView>(R.id.tvJudul).text = film.title
            viewKartu.findViewById<TextView>(R.id.tvGenre).text = "Genre: ${film.genre}"
            viewKartu.findViewById<TextView>(R.id.tvTahun).text = "Rilis: ${film.releaseYear}"

            // Pindah Halaman dengan pengaman Try-Catch
            viewKartu.setOnClickListener {
                try {
                    Log.d(tagNIM, "Aktivitas: Membuka detail film '${film.title}'")
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("EXTRA_JUDUL", film.title)
                    intent.putExtra("EXTRA_GENRE", film.genre)
                    intent.putExtra("EXTRA_TAHUN", film.releaseYear)
                    intent.putExtra("EXTRA_RATING", film.rating)
                    intent.putExtra("EXTRA_SINOPSIS", film.synopsis)
                    startActivity(intent)
                } catch (e: Exception) {
                    Log.e(tagNIM, "Error saat pindah halaman: ${e.message}")
                    Toast.makeText(this, "Gagal membuka halaman detail", Toast.LENGTH_SHORT).show()
                }
            }

            wadahListFilm.addView(viewKartu)
        }
    }

    private fun linearSearch(keyword: String): ArrayList<Film> {
        val hasil = ArrayList<Film>()
        for (film in dataFilmSemua) {
            if (film.title.contains(keyword, ignoreCase = true)) {
                hasil.add(film)
            }
        }
        return hasil
    }

    private fun bubbleSort(list: ArrayList<Film>, isAscending: Boolean): ArrayList<Film> {
        val arr = ArrayList(list)
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                val harusDitukar = if (isAscending) {
                    arr[j].title > arr[j + 1].title
                } else {
                    arr[j].title < arr[j + 1].title
                }
                if (harusDitukar) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }
}