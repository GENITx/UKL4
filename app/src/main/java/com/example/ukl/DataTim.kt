package com.example.ukl

object DataTim {
    private val data = arrayOf(
        arrayOf(
            "Real Madrid",
            "Real Madrid adalah klub sepak bola profesional yang berbasis di Madrid, Spanyol. Didirikan pada tahun 1902 sebagai Madrid Football Club, secara tradisional mengenakan kostum kandang putih. Kata Real (\"dari kerajaan\") Spanyol dan dianugerahkan ke klub oleh Raja Alfonso XIII pada tahun 1920 bersama-sama dengan mahkota kerajaan di lambang klub. Klub ini telah memainkan pertandingan kandang di Stadion Santiago Bernabéu dengan kapasitas 85.454 di pusat kota Madrid sejak tahun 1947.",
            "14 UCL Thropy",
            "https://upload.wikimedia.org/wikipedia/id/thumb/8/8b/Real_Madrid_Club_de_F%C3%BAtbol.png/175px-Real_Madrid_Club_de_F%C3%BAtbol.png"
        ),
        arrayOf(
            "Liverpool",
            "adalah sebuah klub sepak bola asal Inggris yang berbasis di Kota Liverpool. Saat ini Liverpool adalah peserta Liga Utama Inggris. Liverpool didirikan pada tahun 1892 dan bergabung dengan Football League pada tahun berikutnya. Klub ini telah bermain di Stadion Anfield sejak pembentukannya yang terletak sekitar 4,8 km dari pusat kota Liverpool.",
            "6 UCL Thropy",
            "https://upload.wikimedia.org/wikipedia/id/thumb/0/0c/Liverpool_FC.svg/200px-Liverpool_FC.svg.png"

        )
    )
    val listData: ArrayList<Tim>
        get() {
            val list = arrayListOf<Tim>()
            for (aData in data) {
                val tim = Tim()
                tim.name = aData[0]
                tim.from = aData[1]
                tim.thropy = aData[2]
                tim.photo = aData[3]

                list.add(tim)
            }
            return list
        }
}