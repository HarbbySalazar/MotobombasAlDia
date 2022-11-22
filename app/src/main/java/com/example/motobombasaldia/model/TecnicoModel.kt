package com.example.motobombasaldia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tecnicos")
data class TecnicoModel (
    @PrimaryKey()@NotNull
    val identificacion:String,
    @ColumnInfo(name="nombres")@NotNull
    val nombre:String,
    @ColumnInfo(name="apellidos")
    val apellido:String,
    @ColumnInfo(name="direccion")
    val direccion:String,
    @ColumnInfo(name="telefono")
    val telefono: String,
    @ColumnInfo(name="correo")
    val correo: String,
    @ColumnInfo(name="foto")
    val foto: String,
)