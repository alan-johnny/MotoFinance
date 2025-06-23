package com.johnny.motofinance.di

import androidx.room.Room
import com.johnny.motofinance.data.local.db.AppDataBase
import com.johnny.motofinance.data.repository.AbastecimentoRepositoryImpl
import com.johnny.motofinance.data.repository.KmRodadoRepositoryImpl
import com.johnny.motofinance.data.repository.MotoRepositoryImpl
import com.johnny.motofinance.data.repository.PecaRepositoryImpl
import com.johnny.motofinance.data.repository.RendimentoRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDataBase::class.java,
            "moto_finance_db"
        ).build()
    }
    single { get<AppDataBase>().AbastecimentoDaos() }
    single { get<AppDataBase>().KmRodadoDaos()}
    single { get<AppDataBase>().PecaDaos() }
    single { get<AppDataBase>().RendimentoDaos()}
    single {get<AppDataBase>().MotoDaos()}
}

val repositoryModule = module {
    single { AbastecimentoRepositoryImpl(get()) }
    single { KmRodadoRepositoryImpl(get()) }
    single { PecaRepositoryImpl(get()) }
    single { RendimentoRepositoryImpl(get()) }
    single { MotoRepositoryImpl(get()) }
}

val appModules = listOf(databaseModule, repositoryModule)