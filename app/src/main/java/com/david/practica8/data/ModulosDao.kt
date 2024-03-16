package com.david.practica8.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModulosDao {

    @Query("SELECT * FROM modulos ORDER BY id DESC")
    fun getAllModulos(): LiveData<List<Modulos>>

    @Query("DELETE FROM modulos")
    suspend fun clearModulos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModulo(modulo: Modulos)
}