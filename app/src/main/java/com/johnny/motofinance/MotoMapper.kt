package com.johnny.motofinance

import com.johnny.motofinance.data.local.entity.MotoEntity
import com.johnny.motofinance.domain.model.Moto

fun MotoEntity.toMoto(): Moto = Moto(

     id,
     modelo,
     marca,
    placa,
    anodeFabricacao,
    KmAtual

)

fun Moto.toEntity(): MotoEntity = MotoEntity(
    id,
    modelo,
    marca,
    placa,
    anodeFabricacao,
    KmAtual

)