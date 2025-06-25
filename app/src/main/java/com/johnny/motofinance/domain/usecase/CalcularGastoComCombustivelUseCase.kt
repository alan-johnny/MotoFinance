package com.johnny.motofinance.domain.usecase

data class CalculoResultado(
     val litrosGasto: Double,
     val valorGasto: Double,
     val custoPorKm: Double
)

 class CalcularGastoComCombustivelUseCase{

     operator fun invoke(
         kmRodados: Double,
         kmPorlitro: Double,
         precoCombustivel: Double
     ): CalculoResultado {
         if (kmRodados <= 0 || precoCombustivel <= 0 || kmPorlitro <= 0){
             throw IllegalArgumentException("Todos os valores devem ser maior que 0 ")
         }
         val litrosGasto = kmRodados / kmPorlitro
         val valorGasto = litrosGasto * precoCombustivel
         val custoPorKm = valorGasto / kmRodados

         return  CalculoResultado(
             litrosGasto = litrosGasto,
             valorGasto = valorGasto,
             custoPorKm = custoPorKm

         )

     }
 }
