package com.johnny.motofinance.domain.repository

import com.johnny.motofinance.domain.model.Moto
import kotlinx.coroutines.flow.Flow

interface MotoRepository {

    fun getMoto(): Flow<List<Moto>>

    suspend fun insert(moto: Moto)

    suspend fun update(moto: Moto)

    suspend fun delete(moto: Moto)


}