package com.example.jdmcars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CarsAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoCars())
        adapter.onItemClickListener = { cars ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("Id", cars.id)
            intent.putExtra("Modelo", cars.modelo)
            intent.putExtra("Motor", cars.motor)
            intent.putExtra("HP", cars.hp)
            intent.putExtra("KG", cars.kilogramos)
            intent.putExtra("VelocidadMax", cars.velocidadmax)
            intent.putExtra("Marca", cars.marca)
            intent.putExtra("url", cars.url)
            startActivity(intent)
        }
    }

    private fun getListadoCars(): MutableList<Cars>? {
        return mutableListOf(
            Cars(1, "GTR Nismo R35","3.8L V6 Biturbo",600,1778,"315 KM/H",MarcaCars.NISSAN, "https://hips.hearstapps.com/hmg-prod/images/210805-01-j-002-1628251687.jpg?crop=0.754xw:0.636xh;0.116xw,0.242xh&resize=640:*"),
            Cars(2, "GR Supra","3.0L L6 Turbo",382,1580,"250 KM/H",MarcaCars.TOYOTA,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6X5LOvU7lWABg-LcST-rCy0tn6mcu542K0Q&s"),
            Cars(3,"RX7","1.3L Twin-Rotor",276,1280,"250 KM/H",MarcaCars.MAZDA, "https://www.tuningblog.eu/wp-content/uploads/2019/05/Mazda-RX7-Tuning-Coupe-696x419.jpg"),
            Cars(4, "Eclipse","2.0L I4 Turbo",210,1380,"235 KM/H", MarcaCars.MITSUBISHI, "https://fotos.perfil.com/2022/01/16/trim/876/492/mitsubishi-eclipse-1299220.jpg?webp"),
            Cars(5,"Lancer Evolution","2.0L I4 Turbo",291,1540,"250 KM/H",MarcaCars.MITSUBISHI, "https://cdn.motor1.com/images/mgl/2gJ94/s3/mitsubishi-lancer-evo-rendering.webp"),
            Cars(6, "S2000","2.0L I4 VTEC",240,1257,"240 KM/H", MarcaCars.HONDA, "https://www.tuningblog.eu/wp-content/uploads/2017/03/rocket-bunny-pandem-honda-s2000-tuning-3-696x383.jpg"),
            Cars(7,"Civic Type R","2.0L I4 Turbo VTEC",320,1380,"272 KM/H",MarcaCars.HONDA, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0qDpjIuGLsZukYZxmwgKjkSXpmS_5B1ZzSQ&s"),
            Cars(8, "Silvia S15","2.0L I4 Turbo",250,1250,"225 KM/H",MarcaCars.NISSAN, "https://wp-s.ru/wallpapers/1/13/small/448047500263433.jpg"),
            Cars(9,"NSX","3.5L V6 Híbrid Biturbo",573,1725,"307 KM/H",MarcaCars.HONDA, "https://www.tuningblog.eu/wp-content/uploads/2022/09/1991-Honda-NSX-VeilSide-Bodykit-Tuning-Header.jpg"),
            Cars(10,"Miata MX-5", "2.0L I4",181,1050,"219 KM/H",MarcaCars.MAZDA, "https://acnews.blob.core.windows.net/imgnews/extralarge/NAZ_8c87c326fe3547749525adaa2fc99a6d.webp"),
            Cars(11, "GR86","2.4L Bóxer I4",228,1275,"226 KM/H",MarcaCars.TOYOTA, "https://espirituracer.com/archivos/2023/01/toyota-gr86-liberty-walk-tuning-14.webp"),
            Cars(12, "Prelude","2.2L I4 VTEC",200,1320,"225 KM/H",MarcaCars.HONDA,"https://i.pinimg.com/originals/aa/de/06/aade06d26cbd46d0e2a7efce71f9ae44.png"),
            Cars(13,"Accord","2.0L I4 Turbo",252,1500,"210 KM/H",MarcaCars.HONDA, "https://c4.wallpaperflare.com/wallpaper/426/138/382/vossen-wheels-honda-accord-black-honda-coupe-wallpaper-thumb.jpg"),
        )
    }
}