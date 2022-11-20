package com.example.motobombasaldia.dao

import androidx.room.*
import com.example.motobombasaldia.model.UsuarioModel

@Dao
interface UsuarioDAO {
 @Query("Select * from usuarios")
 fun consultarTodos():List<UsuarioModel>

 @Query("Select * from usuarios where usuario =(:usuario)")
 fun consultarUno(usuario:String): List<UsuarioModel>

 @Update
 fun actualizar(usuario:UsuarioModel)

 @Insert(onConflict = OnConflictStrategy.IGNORE)
 fun insertar(usuario:UsuarioModel)

 @Delete
 fun borrar(usuario: UsuarioModel)


}