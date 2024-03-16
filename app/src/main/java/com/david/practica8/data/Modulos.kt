package com.david.practica8.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "modulos")
data class Modulos(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "creditos") val creditos: Int
)
