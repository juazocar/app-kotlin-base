package cl.duoc.app.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.duoc.app.model.entities.FormularioServicioEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FormularioServicioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFormulario(formulario: FormularioServicioEntity): Long

    @Query("SELECT * FROM formulario_servicio ORDER BY id DESC")
    fun getFormularios(): Flow<List<FormularioServicioEntity>>

    @Query("DELETE FROM formulario_servicio")
    suspend fun deleteAll()
}
