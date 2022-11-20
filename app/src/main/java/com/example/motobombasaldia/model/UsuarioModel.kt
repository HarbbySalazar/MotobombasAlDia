package com.example.motobombasaldia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "usuarios")
data class UsuarioModel(
    @ColumnInfo(name="identificacion")
    val identificacion:String,
    @ColumnInfo(name="nombre")@NotNull
    val nombre:String,
    @ColumnInfo(name="apellido")
    val apellido:String,
    @ColumnInfo(name="direccion")
    val direccion:String,
    @ColumnInfo(name="correo")
    val correo: String,
    @ColumnInfo(name="celular")
    val celular: String,
    @PrimaryKey()
    val usuario: String,
    @ColumnInfo(name="clave")
    val clave: String

        )