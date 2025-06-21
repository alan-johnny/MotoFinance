package com.johnny.motofinance.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "moto")
data class MotoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val modelo: String,
    val marca: String,
    val placa: String,
    val anodeFabricacao: Int,
    val KmAtual: Int
)
