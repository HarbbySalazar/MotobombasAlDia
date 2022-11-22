package com.example.motobombasaldia.dao

import androidx.room.*
import com.example.motobombasaldia.model.TecnicoModel

@Dao
interface TecnicoDAO {
    @Query("Select * from tecnicos")
    fun consultarTodos(): List<TecnicoModel>

    @Query("Select * from tecnicos where identificacion =(:identificacion)")
    fun consultarUno(identificacion: String): List<TecnicoModel>

    @Update
    fun actualizar(identificacion: TecnicoModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertar(tecnico: TecnicoModel)

    @Delete
    fun borrar(tecnico: TecnicoModel)
}
