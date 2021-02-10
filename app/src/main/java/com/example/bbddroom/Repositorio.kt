package com.example.bbddroom

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio (val miDAO: PalabraDAO) {
    val listaPalabras= miDAO.MostrarTodas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miPalabra: Palabra){
        miDAO.Insertar(miPalabra)
    }

    suspend fun BuscarPorId(id:Long): Flow<Palabra> {
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