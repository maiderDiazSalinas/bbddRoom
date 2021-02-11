package com.example.bbddroom

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio (val miDAO: PalabraDAO) {
    val listaPalabras: Flow<List<Palabra>> = miDAO.MostrarTodas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miPalabra: Palabra){
        miDAO.Insertar(miPalabra)
    }

    fun BuscarPorId(id:Int): Flow<Palabra> {
        return miDAO.BuscarPorId(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miPalabra: Palabra){
        miDAO.Borrar(miPalabra)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miPalabra: Palabra){
        miDAO.Actualizar(miPalabra)
    }
}