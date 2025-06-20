package com.johnny.motofinance.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pecas")
data class PecaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val  name: String,
    val valor: Double,
    val dataCompra : String,
    val kmInstalacao : Int
)
