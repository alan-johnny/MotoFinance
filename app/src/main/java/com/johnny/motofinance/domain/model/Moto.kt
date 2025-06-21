package com.johnny.motofinance.domain.model

data class Moto (
    val id : Int = 0,
    val modelo: String,
    val marca: String,
    val placa: String,
    val anodeFabricacao: Int,
    val KmAtual: Int
)
