package com.johnny.motofinance.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "km_rodado")
data class KmRodadoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val kmInicial: Int,
    val kmFinal: Int,
    val data: String
)
