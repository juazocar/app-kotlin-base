package cl.duoc.app.model

data class FormularioServicioUIState(
    val nombreCliente: String = "",
    val correoCliente: String = "",
    val region: String = "",
    val errores: FormularioServicioErrores = FormularioServicioErrores()
)