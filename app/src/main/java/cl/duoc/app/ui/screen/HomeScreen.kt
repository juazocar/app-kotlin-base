package cl.duoc.app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.duoc.app.ui.components.InputText
import cl.duoc.app.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val estado by viewModel.estado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Formulario de Servicio",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )

        // Nombre
        InputText(
            valor = estado.nombreCliente,
            error = estado.errores.nombreCliente,
            label = "Nombre del cliente",
            onChange = viewModel::onNombreChange
        )

        // Correo
        InputText(
            valor = estado.correoCliente,
            error = estado.errores.correoCliente,
            label = "Correo electrónico",
            onChange = viewModel::onCorreoChange
        )

        // Región
        InputText(
            valor = estado.region,
            error = estado.errores.region,
            label = "Región",
            onChange = viewModel::onRegionChange
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = viewModel::onEnviarFormulario,
            modifier = Modifier.fillMaxWidth(),
            enabled = !estado.errores.tieneErrores()
        ) {
            Text("Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Si el Preview falla por el ViewModel, crea una versión Stateless para previsualizar.
    HomeScreen()
}
