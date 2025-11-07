package cl.duoc.app.model.data.repository


import cl.duoc.app.model.data.dao.FormularioServicioDao
import cl.duoc.app.model.data.entities.FormularioServicioEntity

class FormularioServicioRepository(private val dao: FormularioServicioDao) {

    fun obtenerFormularios() = dao.getFormularios()

    suspend fun guardarFormulario(entity: FormularioServicioEntity): Long {
        return dao.insertFormulario(entity)
    }

    suspend fun limpiar() = dao.deleteAll()
}
