package com.example.bbddroom

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PalabraDAO {
    @Query("SELECT * FROM tabla_palabras ORDER BY palabra ASC")
    fun MostrarTodas(): Flow<List<Palabra>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun Insertar(word: Palabra)

    @Query("DELETE FROM tabla_palabras")
    suspend fun BorrarTodo()

    @Query("SELECT * FROM tabla_palabras where id like :id")
    suspend fun BuscarPorId(id: Long): Flow<Palabra>

    @Update
    suspend fun Actualizar(word: Palabra)

    @Delete
    suspend fun Borrar(word: Palabra)

}