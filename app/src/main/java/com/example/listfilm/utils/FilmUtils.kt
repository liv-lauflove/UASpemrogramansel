package com.example.listfilm.utils
import com.example.listfilm.models.Film

object FilmUtils {
    fun getFilmList(): ArrayList<Film> {
        val list = ArrayList<Film>()

        list.add(
            Film(
                title = "Inception",
                type = "Movie",
                genre = "Sci-Fi",
                releaseYear = 2010,
                rating = 8.8,
                synopsis = "Seorang pencuri profesional yang mencuri informasi dengan menyusup ke alam bawah sadar targetnya, diberikan tugas untuk menanamkan ide ke dalam pikiran seorang CEO."
            )
        )

        list.add(
            Film(
                title = "Notting Hill",
                type = "Movie",
                genre = "RomCom",
                releaseYear = 1999,
                rating = 7.2,
                synopsis = "Kehidupan seorang pemilik toko buku yang sederhana di London berubah drastis ketika bintang film paling terkenal di dunia masuk ke tokonya."
            )
        )

        list.add(
            Film(
                title = "Breaking Bad",
                type = "Series",
                genre = "Crime",
                releaseYear = 2008,
                rating = 9.5,
                synopsis = "Seorang guru kimia SMA yang didiagnosis kanker paru-paru beralih memproduksi dan menjual sabu untuk mengamankan masa depan keuangan keluarganya."
            )
        )

        list.add(
            Film(
                title = "Interstellar",
                type = "Movie",
                genre = "Sci-Fi",
                releaseYear = 2014,
                rating = 8.7,
                synopsis = "Sekelompok penjelajah melakukan perjalanan melalui lubang cacing di luar angkasa dalam upaya untuk memastikan kelangsungan hidup umat manusia."
            )
        )

        list.add(
            Film(
                title = "Stranger Things",
                type = "Series",
                genre = "Horror/Sci-Fi",
                releaseYear = 2016,
                rating = 8.7,
                synopsis = "Ketika seorang anak laki-laki menghilang, sebuah kota kecil mengungkap misteri yang melibatkan eksperimen rahasia, kekuatan supernatural, dan seorang gadis kecil yang aneh."
            )
        )

        list.add(
            Film(
                title = "The Dark Knight",
                type = "Movie",
                genre = "Action",
                releaseYear = 2008,
                rating = 9.0,
                synopsis = "Ketika ancaman yang dikenal sebagai Joker mendatangkan kekacauan di kota Gotham, Batman harus menerima salah satu tes psikologis dan fisik terbesar."
            )
        )

        list.add(
            Film(
                title = "Game of Thrones",
                type = "Series",
                genre = "Fantasy",
                releaseYear = 2011,
                rating = 9.2,
                synopsis = "Sembilan keluarga bangsawan bertarung memperebutkan kendali atas tanah mistis Westeros, sementara musuh kuno kembali setelah tertidur ribuan tahun."
            )
        )

        list.add(
            Film(
                title = "The Matrix",
                type = "Movie",
                genre = "Sci-Fi",
                releaseYear = 1999,
                rating = 8.7,
                synopsis = "Seorang hacker komputer belajar dari pemberontak misterius tentang sifat sebenarnya dari realitasnya dan perannya dalam perang melawan pengendalinya."
            )
        )

        list.add(
            Film(
                title = "The Office",
                type = "Series",
                genre = "Comedy",
                releaseYear = 2005,
                rating = 9.0,
                synopsis = "Sebuah mokumenter yang menceritakan kehidupan sehari-hari para pekerja kantoran di cabang Scranton, Pennsylvania dari Perusahaan Kertas Dunder Mifflin."
            )
        )

        list.add(
            Film(
                title = "Avengers: Endgame",
                type = "Movie",
                genre = "Action",
                releaseYear = 2019,
                rating = 8.4,
                synopsis = "Setelah peristiwa dahsyat yang disebabkan oleh Thanos, anggota Avengers yang tersisa harus berkumpul sekali lagi untuk memulihkan keseimbangan alam semesta."
            )
        )

        list.add(
            Film(
                title = "How to Lose a Guy in 10 Days",
                type = "Movie",
                genre = "RomCom",
                releaseYear = 2003,
                rating = 6.5,
                synopsis = "Seorang jurnalis wanita mencoba membuat pria menjauhinya dalam 10 hari untuk artikelnya, sementara pria tersebut bertaruh bahwa ia bisa membuat wanita jatuh cinta padanya dalam waktu yang sama."
            )
        )

        list.add(
            Film(
                title = "Chernobyl",
                type = "Series",
                genre = "Historical Drama",
                releaseYear = 2019,
                rating = 9.4,
                synopsis = "Dramatisasi kisah nyata salah satu bencana buatan manusia terburuk dalam sejarah dan pengorbanan yang dilakukan untuk menyelamatkan Eropa dari bencana yang tak terbayangkan."
            )
        )

        return list
    }
}