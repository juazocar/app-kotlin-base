package cl.duoc.app.viewmodel

import androidx.lifecycle.ViewModel
import cl.duoc.app.model.FormularioServicioErrores
import cl.duoc.app.model.FormularioServicioUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormularioServicioViewModel : ViewModel() {

    private val _estado = MutableStateFlow(FormularioServicioUIState())
    val estado: StateFlow<FormularioServicioUIState> = _estado.asStateFlow()

    fun onNombreChange(valor: String) {
        _estado.update { actual ->
            actual.copy(
                nombreCliente = valor,
                errores = actual.errores.copy(
                    nombreCliente = if (valor.isBlank()) "El nombre es obligatorio" else null
                )
            )
        }
    }

    fun onCorreoChange(valor: String) {
        _estado.update { actual ->
            actual.copy(
                correoCliente = valor,
                errores = actual.errores.copy(
                    correoCliente = when {
                        valor.isBlank() -> "El correo es obligatorio"
                        !EMAIL_REGEX.matches(valor) -> "Formato de correo no válido"
                        else -> null
                    }
                )
            )
        }
    }

    fun onRegionChange(valor: String) {
        _estado.update { actual ->
            actual.copy(
                region = valor,
                errores = actual.errores.copy(
                    region = if (valor.isBlank()) "La región es obligatoria" else null
                )
            )
        }
    }

    fun onEnviarFormulario() {
        val s = _estado.value
        val errores = FormularioServicioErrores(
            nombreCliente = if (s.nombreCliente.isBlank()) "El nombre es obligatorio" else null,
            correoCliente = when {
                s.correoCliente.isBlank() -> "El correo es obligatorio"
                !EMAIL_REGEX.matches(s.correoCliente) -> "Formato de correo no válido"
                else -> null
            },
            region = if (s.region.isBlank()) "La región es obligatoria" else null
        )

        _estado.update { it.copy(errores = errores) }

        if (!errores.tieneErrores()) {
            // TODO: acción de envío (e.g., llamar a repositorio / navegar)
        }
    }

    companion object {
        private val EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    }
}
