package com.example.listfilm // Pastikan nama package tidak berubah!

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
import com.example.listfilm.models.Film // Ganti jadi model.Film kalau error merah

class MainActivity : AppCompatActivity() {

    // Siapkan variabel global agar bisa diakses oleh semua tombol
    private lateinit var wadahListFilm: LinearLayout
    private lateinit var dataFilmSemua: ArrayList<Film>
    private var dataSaatIni: ArrayList<Film> = ArrayList()

    // Gunakan NIM kamu untuk Tag Logcat
    private val tagNIM = "42430058"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Kenalkan elemen UI
        wadahListFilm = findViewById(R.id.wadahListFilm)
        val inputCari = findViewById<EditText>(R.id.inputCari)
        val btnCari = findViewById<Button>(R.id.btnCari)
        val btnSortAZ = findViewById<Button>(R.id.btnSortAZ)
        val btnSortZA = findViewById<Button>(R.id.btnSortZA)

        // 2. Ambil data dari Util saat aplikasi pertama kali buka
        dataFilmSemua = FilmUtils.getFilmList()
        dataSaatIni.addAll(dataFilmSemua) // Copy data untuk dimanipulasi
        tampilkanData(dataSaatIni) // Cetak ke layar

        // =====================================
        // AKSI TOMBOL (TRIGGERS)
        // =====================================

        // Modul 4, 5, 6: Klik Tombol Cari (Validasi & Linear Search)
        btnCari.setOnClickListener {
            val keyword = inputCari.text.toString()

            if (keyword.isEmpty()) {
                inputCari.error = "Kolom tidak boleh kosong!"
                dataSaatIni.clear()
                dataSaatIni.addAll(dataFilmSemua)
                tampilkanData(dataSaatIni) // Tampilkan semua film kembali
            } else {
                Log.d(tagNIM, "Menjalankan Linear Search untuk: $keyword")
                val hasilCari = linearSearch(keyword)

                if (hasilCari.isEmpty()) {
                    Toast.makeText(this, "Film tidak ditemukan!", Toast.LENGTH_SHORT).show()
                }

                dataSaatIni = hasilCari
                tampilkanData(dataSaatIni) // Tampilkan hasil pencarian
            }
        }

        // Modul 7: Klik Tombol Sort A-Z (Bubble Sort Ascending)
        btnSortAZ.setOnClickListener {
            Log.d(tagNIM, "Menjalankan Bubble Sort A-Z")
            val hasilSort = bubbleSort(dataSaatIni, isAscending = true)
            dataSaatIni = hasilSort
            tampilkanData(dataSaatIni)
            Toast.makeText(this, "Diurutkan A - Z", Toast.LENGTH_SHORT).show()
        }

        // Modul 7: Klik Tombol Sort Z-A (Bubble Sort Descending)
        btnSortZA.setOnClickListener {
            Log.d(tagNIM, "Menjalankan Bubble Sort Z-A")
            val hasilSort = bubbleSort(dataSaatIni, isAscending = false)
            dataSaatIni = hasilSort
            tampilkanData(dataSaatIni)
            Toast.makeText(this, "Diurutkan Z - A", Toast.LENGTH_SHORT).show()
        }
    }

    // =====================================
    // RUMUS LOGIKA & ALGORITMA
    // =====================================

    // Fungsi Render: Membersihkan dan mencetak ulang kartu film ke layar
    private fun tampilkanData(listFilm: ArrayList<Film>) {
        wadahListFilm.removeAllViews() // PENTING: Bersihkan layar sebelum mencetak yang baru

        for (film in listFilm) {
            val viewKartu: View = LayoutInflater.from(this).inflate(R.layout.item_film, wadahListFilm, false)

            viewKartu.findViewById<TextView>(R.id.tvJudul).text = film.title
            viewKartu.findViewById<TextView>(R.id.tvGenre).text = "Genre: ${film.genre}"
            viewKartu.findViewById<TextView>(R.id.tvTahun).text = "Rilis: ${film.releaseYear}"

            // Intent Pindah Halaman
            viewKartu.setOnClickListener {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("EXTRA_JUDUL", film.title)
                intent.putExtra("EXTRA_GENRE", film.genre)
                intent.putExtra("EXTRA_TAHUN", film.releaseYear)
                intent.putExtra("EXTRA_RATING", film.rating)
                intent.putExtra("EXTRA_SINOPSIS", film.synopsis)
                startActivity(intent)
            }

            wadahListFilm.addView(viewKartu)
        }
    }

    // Logika Modul 6: Linear Search
    private fun linearSearch(keyword: String): ArrayList<Film> {
        val hasil = ArrayList<Film>()
        // Cek satu-satu dari awal sampai akhir array
        for (film in dataFilmSemua) {
            if (film.title.contains(keyword, ignoreCase = true)) {
                hasil.add(film)
            }
        }
        return hasil
    }

    // Logika Modul 7: Bubble Sort
    private fun bubbleSort(list: ArrayList<Film>, isAscending: Boolean): ArrayList<Film> {
        val arr = ArrayList(list) // Copy data agar data asli tidak rusak
        val n = arr.size

        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                // Tentukan kondisi tukar: Apakah A-Z (>) atau Z-A (<)
                val harusDitukar = if (isAscending) {
                    arr[j].title > arr[j + 1].title
                } else {
                    arr[j].title < arr[j + 1].title
                }

                // Proses Swap (Tukar Posisi)
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