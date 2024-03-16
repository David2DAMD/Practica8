package com.david.practica8

import android.app.Application
import com.david.practica8.data.database.LocalRepository
import com.david.practica8.data.database.ModulosDatabase

class ModulosApp: Application() {
    private val database: ModulosDatabase by lazy{
        ModulosDatabase.getDatabase(this)
    }

    val localRepo: LocalRepository by lazy {LocalRepository(database)}

}
