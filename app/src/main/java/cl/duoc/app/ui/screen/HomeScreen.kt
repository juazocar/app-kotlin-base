package cl.duoc.app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.duoc.app.R
import cl.duoc.app.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
   val estado by viewModel.estado.collectAsState()

   Column (Modifier.padding(16.dp)){
       OutlinedTextField(
           value = estado.nombreCliente,
           onValueChange = viewModel::onNombreChange,
           label = { Text("Nombre del cliente")},
           modifier = Modifier.fillMaxWidth()
           )
   }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onPrimaryAction = { /*TODO*/ }) {

    }
}