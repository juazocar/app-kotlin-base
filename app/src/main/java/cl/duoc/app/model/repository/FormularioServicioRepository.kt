package cl.duoc.app.model.repository


import cl.duoc.app.model.data.FormularioServicioDao
import cl.duoc.app.model.entities.FormularioServicioEntity

class FormularioServicioRepository(
    private val dao: FormularioServicioDao
) {

    fun obtenerFormularios() = dao.getFormularios()

    suspend fun guardarFormulario(entity: FormularioServicioEntity): Long {
        return dao.insertFormulario(entity)
    }

    suspend fun limpiar() = dao.deleteAll()
}
