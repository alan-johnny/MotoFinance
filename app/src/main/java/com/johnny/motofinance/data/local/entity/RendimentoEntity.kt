package com.johnny.motofinance.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rendimentos")
data class RendimentoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val valorGanhos: Double,
    val data : String
)
