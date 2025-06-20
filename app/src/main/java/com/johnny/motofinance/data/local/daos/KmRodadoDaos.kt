package com.johnny.motofinance.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johnny.motofinance.data.local.entity.KmRodadoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface KmRodadoDaos {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(kmRodado: KmRodadoEntity)

    @Delete
    suspend fun delete(kmRodado: KmRodadoEntity)

    @Query("SELECT * FROM km_rodado")
    fun getAll(): Flow<List<KmRodadoEntity>>

    @Query("SELECT * FROM km_rodado WHERE id = id")
    suspend fun getById(id: Int):KmRodadoEntity
}