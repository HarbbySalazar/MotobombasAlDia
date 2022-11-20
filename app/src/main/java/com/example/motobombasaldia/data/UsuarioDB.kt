package com.example.motobombasaldia.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.motobombasaldia.dao.UsuarioDAO
import com.example.motobombasaldia.model.UsuarioModel

@Database(
    entities=[UsuarioModel::class],
    version = 1, exportSchema = false
)
abstract class UsuarioDB:RoomDatabase() {
    abstract val usuarioDAO:UsuarioDAO
    companion object{
        const val DATABASE_NAME="bdMotobombas"
    }
}
