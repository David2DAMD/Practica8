package com.david.practica8.data.database

import androidx.lifecycle.LiveData
import com.david.practica8.data.Modulos

class LocalRepository(private val dataBase: ModulosDatabase) {

    private val dao = dataBase.dao()

    val getAllModulos: LiveData<List<Modulos>> = dao.getAllModulos()

    suspend fun insertModulo(nombreLr: String, creditosLr: Int){
        val moduloEntity = Modulos(nombre = nombreLr, creditos = creditosLr)
        dao.insertModulo(moduloEntity)
    }

    suspend fun clearModulos(){
        dao.clearModulos()
    }

}