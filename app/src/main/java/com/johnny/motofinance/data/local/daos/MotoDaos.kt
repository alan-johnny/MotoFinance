package com.johnny.motofinance.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.johnny.motofinance.data.local.entity.MotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MotoDaos {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(moto: MotoEntity)

    @Delete
    suspend fun delete(moto: MotoEntity)

    @Query("SELECT * FROM moto")
    fun getAll(): Flow<List<MotoEntity>>

    @Query("SELECT * FROM moto WHERE id = id")
    suspend fun getById(id: Int): MotoEntity

}