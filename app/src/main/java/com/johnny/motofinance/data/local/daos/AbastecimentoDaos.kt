package com.johnny.motofinance.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johnny.motofinance.data.local.entity.AbastecimentoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AbastecimentoDaos {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(abastecimento: AbastecimentoEntity)

    @Delete
    suspend fun delete(abastecimento: AbastecimentoEntity)

    @Query("SELECT * FROM abastecimentos")
    fun getAll(): Flow<List<AbastecimentoEntity>>

    @Query("SELECT * FROM abastecimentos WHERE id = id")
    suspend fun getByID(id: Int): AbastecimentoEntity
}