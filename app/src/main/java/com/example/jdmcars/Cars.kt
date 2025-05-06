package com.example.jdmcars

data class Cars(
    val id: Int,
    val modelo: String,
    val motor: String,
    val hp: Int,
    val kilogramos: Int,
    val velocidadmax: String,
    val marca: MarcaCars,
    val url: String
)

enum class MarcaCars {
    MAZDA, TOYOTA, NISSAN, HONDA, MITSUBISHI,
}