package com.example.bbddroom

import androidx.annotation.WorkerThread
import java.util.concurrent.Flow

class Repositorio (val miDAO: PalabraDAO) {
    val listaPalabras = miDAO.MostrarTodas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Insertar(miPalabra: Palabra){
        miDAO.Insertar(miPalabra)
    }

    suspend fun BuscarPorId(id:Long): Flow<Palabra> {
        return miDAO.BuscarPorId(id)
    }
}