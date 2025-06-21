package com.johnny.motofinance.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.johnny.motofinance.data.local.daos.AbastecimentoDaos
import com.johnny.motofinance.data.local.daos.KmRodadoDaos
import com.johnny.motofinance.data.local.daos.MotoDaos
import com.johnny.motofinance.data.local.daos.PecaDaos
import com.johnny.motofinance.data.local.daos.RendimentoDaos
import com.johnny.motofinance.data.local.entity.AbastecimentoEntity
import com.johnny.motofinance.data.local.entity.KmRodadoEntity
import com.johnny.motofinance.data.local.entity.MotoEntity
import com.johnny.motofinance.data.local.entity.PecaEntity
import com.johnny.motofinance.data.local.entity.RendimentoEntity


@Database(
    entities = [
        AbastecimentoEntity::class,
        KmRodadoEntity::class,
        PecaEntity::class,
        RendimentoEntity::class,
        MotoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun AbastecimentoDaos(): AbastecimentoDaos
    abstract fun KmRodadoDaos(): KmRodadoDaos
    abstract fun PecaDaos(): PecaDaos
    abstract fun RendimentoDaos(): RendimentoDaos
    abstract fun MotoDaos(): MotoDaos


}
