package com.david.practica8.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.david.practica8.data.Modulos
import com.david.practica8.data.ModulosDao

@Database(version = 1, entities = [Modulos::class])
abstract class ModulosDatabase : RoomDatabase() {

    abstract fun dao(): ModulosDao

    companion object {
        @Volatile
        private var INSTANCE: ModulosDatabase? = null
        fun getDatabase(context: Context): ModulosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ModulosDatabase::class.java,
                    "modulos_list"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}