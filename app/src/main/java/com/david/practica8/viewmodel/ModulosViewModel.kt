package com.david.practica8.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.david.practica8.ModulosApp
import com.david.practica8.data.database.LocalRepository
import kotlinx.coroutines.launch

class ModulosViewModel(val repository: LocalRepository): ViewModel() {

    val allModulos = repository.getAllModulos

    fun clearModulos(){
        viewModelScope.launch {
            repository.clearModulos()
        }
    }

    fun insertModulos(nombre: String, creditos: Int){
        viewModelScope.launch {
            repository.insertModulo(nombre, creditos)
        }
    }
}

class ModulosViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val app = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as ModulosApp
        val repo = app.localRepo
        return ModulosViewModel(repo) as T
    }
}