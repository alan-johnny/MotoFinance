package com.johnny.motofinance.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "abastecimentos")
data class AbastecimentoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val litros: Double,
    val  valor: Double,
    val kmAtual: Int,
    val data: String
)
