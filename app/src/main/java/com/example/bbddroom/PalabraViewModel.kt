package com.example.bbddroom

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class PalabraViewModel(private val miRepositorio:Repositorio): ViewModel() {
    val allWords: LiveData<List<Palabra>> = miRepositorio.listaPalabras.asLiveData()
    lateinit var miPalabra:LiveData<Palabra>

    fun Insertar (miPalabra: Palabra) = viewModelScope.launch{
        miRepositorio.Insertar(miPalabra)
    }

    fun BuscarPorId (id:Int) =viewModelScope.launch {
         miPalabra = miRepositorio.BuscarPorId(id).asLiveData()
    }

    fun Borrar(miPalabra: Palabra) =viewModelScope.launch{
        miRepositorio.Borrar(miPalabra)
    }

    fun Actualizar(miPalabra: Palabra) =viewModelScope.launch{
        miRepositorio.Actualizar(miPalabra)
    }
}

class WordViewModelFactory(private val repository: Repositorio) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PalabraViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PalabraViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}