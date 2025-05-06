package com.example.jdmcars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textViewName: TextView
    private lateinit var textViewMotor: TextView
    private lateinit var textViewHP: TextView
    private lateinit var textViewKG: TextView
    private lateinit var textViewVelocidad: TextView
    private lateinit var textViewMarca: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imageView = findViewById(R.id.imageViewDetalle)
        textViewName = findViewById(R.id.textViewName)
        textViewMotor = findViewById(R.id.textViewMotor)
        textViewHP = findViewById(R.id.textViewHp)
        textViewKG = findViewById(R.id.textViewPeso)
        textViewVelocidad = findViewById(R.id.textViewVelocidad)
        textViewMarca = findViewById(R.id.textViewMarca)

        val modelo = intent.getStringExtra("Modelo")!!
        val motor = intent.getStringExtra("Motor")!!
        val hp = intent.getIntExtra("HP", 0)
        val kg = intent.getIntExtra("KG", 0)
        val velocidad = intent.getStringExtra("VelocidadMax")!!
        val marca = intent.getSerializableExtra("Marca", MarcaCars::class.java)?.toString()
        val url = intent.getStringExtra("url")!!


        textViewName.text = "Modelo: $modelo"
        textViewMotor.text = "Motor: $motor"
        textViewHP.text = "HP: $hp"
        textViewKG.text = "Peso: $kg kg"
        textViewVelocidad.text = "Velocidad Máx: $velocidad"
        textViewMarca.text = "Marca: $marca"

        Glide.with(this)
            .load(url)
            .into(imageView)
    }
}
