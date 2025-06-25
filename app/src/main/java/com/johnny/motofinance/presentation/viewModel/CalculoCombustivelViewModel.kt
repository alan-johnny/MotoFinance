package com.johnny.motofinance.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnny.motofinance.domain.usecase.CalcularGastoComCombustivelUseCase
import com.johnny.motofinance.domain.usecase.CalculoResultado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalculoCombustivelViewModel(
    private val calcularGastoUseCase: CalcularGastoComCombustivelUseCase
): ViewModel(){

    private val _resultado = MutableStateFlow<CalculoResultado?>(null)
    val resultado: StateFlow<CalculoResultado?> = _resultado

    private val _erro = MutableStateFlow<String?>(null)
    val erro : StateFlow<String?> = _erro

    fun calcular(kmRodados: Double, kmPorLitro: Double, precoDoCombustivel: Double){
        viewModelScope.launch {
            try {
                val resultado = calcularGastoUseCase(
                    kmRodados = kmRodados,
                    precoCombustivel = precoDoCombustivel,
                    kmPorlitro = kmPorLitro
                )
                _resultado.value = resultado
                _erro.value = null
            } catch (e: Exception){
                _erro.value = e.message
                _resultado.value = null
            }
        }
    }

}