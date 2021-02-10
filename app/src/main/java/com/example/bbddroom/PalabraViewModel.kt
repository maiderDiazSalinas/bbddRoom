package com.example.bbddroom

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class PalabraViewModel(private val miRepositorio:Repositorio): ViewModel() {
    val allWords: LiveData<List<Palabra>> = miRepositorio.listaPalabras.asLiveData()
    var id by Delegates.notNull<Long>()
    lateinit var miPalabra:LiveData<Palabra>

    fun Insertar (miPalabra: Palabra) = viewModelScope.launch{
        miRepositorio.Insertar(miPalabra)
    }

    fun BuscarPorId (id:Long) =viewModelScope.launch {
         miPalabra = miRepositorio.BuscarPorId(id).asLiveData()
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