package com.johnny.motofinance.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johnny.motofinance.data.local.entity.PecaEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PecaDaos {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(peca: PecaEntity)

    @Delete
    suspend fun delete(peca: PecaEntity)

    @Query("SELECT * FROM pecas")
    fun getAllPecas(): Flow<List<PecaEntity>>

    @Query("SELECT * FROM pecas WHERE id= id")
    suspend fun getPecaById(id: Int): PecaEntity
}