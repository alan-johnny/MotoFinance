package com.johnny.motofinance.presentation.screens

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.johnny.motofinance.presentation.viewModel.CalculoCombustivelViewModel

@Composable
fun CalculoCombustivelScreen(
    viewModel: CalculoCombustivelViewModel = viewModel()
) {
    var kmRodados by remember { mutableStateOf("") }
    var kmPorLitro by remember { mutableStateOf("") }
    var precoCombustivel by remember { mutableStateOf("") }

    val resultado = viewModel.resultado.collectAsState()
    val erro = viewModel.erro.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Cálculo de Custo por Km", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = kmRodados,
            onValueChange = { kmRodados = it },
            label = { Text("KM rodados") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = kmPorLitro,
            onValueChange = { kmPorLitro = it },
            label = { Text("KM por litro da moto") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true
        )


        OutlinedTextField(
            value = precoCombustivel,
            onValueChange = { precoCombustivel = it },
            label = { Text("Preço da combustivel") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val km = kmRodados.toDoubleOrNull() ?: 0.0
            val kmLitro = kmPorLitro.toDoubleOrNull() ?: 0.0
            val preco = precoCombustivel.toDoubleOrNull() ?: 0.0
            viewModel.calcular(km, kmLitro, preco)
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(24.dp))

        resultado.value?.let {
            Text("Total gasto com combustível: R$ ${String.format("%.2f", it.valorGasto)}")
            Text("Custo por KM: R$ ${String.format("%.2f", it.custoPorKm)}")
        }
        erro.value?.let {
            Text("Erro: $it", color = MaterialTheme.colorScheme.error)
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculoCombustivelPreview() {
    CalculoCombustivelScreen()
}