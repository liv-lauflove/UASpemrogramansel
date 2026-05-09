<div align="center">

# LISTFILM — Movie & Series Catalog App

**Aplikasi katalog film dan series berbasis Android untuk pencarian, pengurutan, dan detail informasi film secara sederhana, rapi, dan informatif.**

<br>

![Kotlin](https://img.shields.io/badge/Kotlin-Android-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-Project-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![Status](https://img.shields.io/badge/Status-UAS%20Project-blue?style=for-the-badge)
![Logcat](https://img.shields.io/badge/Logcat-42430058-orange?style=for-the-badge)

</div>

---

## Identitas Proyek

| Keterangan | Data |
|---|---|
| Nama | **Olyvia Audy Djohari** |
| NIM | **42430058** |
| Mata Kuliah | **Pemrograman Seluler** |
| Topik | **Katalog Film dan Series** |
| Platform | **Android** |
| Bahasa | **Kotlin** |

---

## Abstract

**ListFilm** adalah aplikasi Android yang menampilkan daftar film dan series beserta informasi genre, tahun rilis, rating, dan sinopsis. Aplikasi ini dikembangkan menggunakan Kotlin dengan data lokal berbasis `ArrayList`, fitur pencarian menggunakan **Linear Search**, pengurutan data menggunakan **Bubble Sort**, navigasi antar halaman menggunakan **Intent**, serta pencatatan aktivitas aplikasi melalui **Logcat** dengan tag NIM.

**Keywords:** Android, Kotlin, Film Catalog, ArrayList, Linear Search, Bubble Sort, Intent, Logcat.

---

## I. Introduction

Project ini dibuat sebagai implementasi UAS mata kuliah Pemrograman Seluler. Aplikasi berfokus pada pengelolaan data film dan series secara sederhana agar pengguna dapat melihat daftar, mencari judul tertentu, mengurutkan data, dan membuka detail informasi film.

Tujuan utama aplikasi:

- Menampilkan daftar film dan series.
- Mencari film berdasarkan judul.
- Mengurutkan data dari A-Z dan Z-A.
- Menampilkan detail film melalui halaman berbeda.
- Menerapkan `try-catch` dan Logcat sebagai bukti aktivitas sistem.

---

## II. System Design

### A. Struktur Halaman

| Halaman | Fungsi Utama |
|---|---|
| `MainActivity` | Menampilkan daftar film, input pencarian, tombol sort A-Z, dan tombol sort Z-A. |
| `DetailActivity` | Menampilkan detail film berupa judul, genre, tahun, rating, dan sinopsis. |

### B. Struktur Package

```text
com.example.listfilm
├── MainActivity.kt
├── DetailActivity.kt
├── models
│   └── Film.kt
└── utils
    └── FilmUtils.kt
```

### C. Alur Aplikasi

```text
User membuka aplikasi
        ↓
MainActivity memuat data dari FilmUtils
        ↓
User dapat mencari / mengurutkan / memilih film
        ↓
DetailActivity menampilkan informasi film yang dipilih
```

---

## III. Implementation

### A. Data Model

Data film disimpan dalam model `Film` dengan atribut:

| Atribut | Keterangan |
|---|---|
| `title` | Judul film atau series |
| `type` | Jenis konten, misalnya Movie atau Series |
| `genre` | Genre film |
| `releaseYear` | Tahun rilis |
| `rating` | Nilai rating |
| `synopsis` | Ringkasan cerita |
| `poster` | Gambar poster film yang ditampilkan pada aplikasi |

### B. Data Lokal

Data film disimpan secara lokal di dalam file `FilmUtils.kt` menggunakan `ArrayList`. Setiap data film berisi informasi seperti judul, jenis film, genre, tahun rilis, rating, sinopsis, dan poster. Data ini digunakan untuk menampilkan daftar film pada halaman utama serta menampilkan detail film saat salah satu item dipilih.

### C. Linear Search

Fitur pencarian menggunakan **Linear Search** dengan cara memeriksa setiap judul film satu per satu berdasarkan kata kunci yang dimasukkan pengguna.

### D. Bubble Sort

Fitur sort A-Z dan Z-A menggunakan **Bubble Sort** berdasarkan judul film. Pengurutan dapat dilakukan secara ascending maupun descending.

### E. Intent Navigation

Ketika pengguna memilih salah satu film, data dikirim dari `MainActivity` ke `DetailActivity` menggunakan `Intent` dan `putExtra()`.

### F. Error Handling & Logcat

Aplikasi menerapkan `try-catch` pada proses pemuatan data, pencarian, sorting, dan perpindahan halaman. Aktivitas aplikasi juga dicatat melalui Logcat dengan tag:

```text
42430058
```

---

## IV. Fitur Utama

| No | Fitur | Status |
|---|---|---|
| 1 | Menampilkan daftar film dan series | ✅ |
| 2 | Pencarian judul film | ✅ |
| 3 | Sorting A-Z | ✅ |
| 4 | Sorting Z-A | ✅ |
| 5 | Halaman detail film | ✅ |
| 6 | Validasi input kosong | ✅ |
| 7 | Try-catch error handling | ✅ |
| 8 | Logcat dengan tag NIM | ✅ |

---

## V. User Interface Documentation

Simpan screenshot aplikasi ke folder berikut:

```text
docs/
```

Gunakan nama file di bawah ini agar gambar otomatis tampil di README.

### A. Tampilan Utama

| Home Screen | Search Result |
|---|---|
| ![Home Screen]() | ![Search Result](docs/search-result.png) |

### B. Sorting Data

| Sort A-Z | Sort Z-A |
|---|---|
| ![Sort AZ](docs/sort-az.png) | ![Sort ZA](docs/sort-za.png) |

### C. Detail & Logcat

| Detail Film | Logcat Evidence |
|---|---|
| ![Detail Screen](docs/detail-screen.png) | ![Logcat](docs/logcat.png) |

> Jika gambar belum muncul, pastikan folder `docs/` berada sejajar dengan file `README.md`.

---

## VI. Testing Result

| No | Test Case | Expected Result | Status |
|---|---|---|---|
| 1 | Membuka aplikasi | Halaman utama tampil | ✅ Passed |
| 2 | Memuat data film | Daftar film muncul | ✅ Passed |
| 3 | Mencari film | Data terfilter sesuai keyword | ✅ Passed |
| 4 | Search kosong | Muncul validasi input | ✅ Passed |
| 5 | Sort A-Z | Data tersusun alfabet naik | ✅ Passed |
| 6 | Sort Z-A | Data tersusun alfabet turun | ✅ Passed |
| 7 | Klik item film | Halaman detail terbuka | ✅ Passed |
| 8 | Membuka Logcat | Aktivitas tercatat dengan tag NIM | ✅ Passed |

---

## VII. How to Run

1. Clone repository ini.
2. Buka project menggunakan **Android Studio**.
3. Tunggu proses **Gradle Sync** selesai.
4. Jalankan aplikasi pada emulator atau perangkat Android.
5. Untuk melihat aktivitas aplikasi, buka **Logcat** dan gunakan filter:

```text
42430058
```

---

## VIII. Conclusion

Aplikasi **ListFilm** berhasil menerapkan konsep dasar pengembangan aplikasi Android menggunakan Kotlin, mulai dari pemodelan data, tampilan berbasis XML, pencarian Linear Search, pengurutan Bubble Sort, navigasi Intent, error handling, hingga dokumentasi Logcat. Project ini ringkas, mudah dipahami, dan sesuai untuk dokumentasi UAS Pemrograman Seluler.

---

<div align="center">

**Built with Kotlin. Designed for clean mobile catalog experience.**

UAS Pemrograman Seluler — 2026

</div>
