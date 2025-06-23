package com.johnny.motofinance.data.repository

import com.johnny.motofinance.data.local.daos.MotoDaos
import com.johnny.motofinance.domain.model.Moto
import com.johnny.motofinance.domain.repository.MotoRepository
import com.johnny.motofinance.toEntity
import com.johnny.motofinance.toMotoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MotoRepositoryImpl(private val daos: MotoDaos) : MotoRepository{
    override fun getMoto(): Flow<List<Moto>> {
       return daos.getAll().map { list ->
           list.map { it.toMotoModel() }
       }
    }

    override suspend fun insert(moto: Moto) {
        daos.insert(moto.toEntity())
    }

    override suspend fun update(moto: Moto) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(moto: Moto) {
        daos.delete(moto.toEntity())
    }
}