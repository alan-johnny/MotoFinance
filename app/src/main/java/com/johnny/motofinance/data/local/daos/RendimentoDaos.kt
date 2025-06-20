package com.johnny.motofinance.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johnny.motofinance.data.local.entity.RendimentoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RendimentoDaos {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rendimento: RendimentoEntity)

    @Delete
    suspend fun delete(rendimento: RendimentoEntity)

    @Query("SELECT * FROM rendimentos")
    fun getAll(): Flow<List<RendimentoEntity>>

    @Query("SELECT * FROM rendimentos WHERE id = id")
    suspend fun getByID(id: Int): RendimentoEntity

}