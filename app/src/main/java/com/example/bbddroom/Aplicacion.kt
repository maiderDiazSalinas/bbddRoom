package com.example.bbddroom

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class Aplicacion : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { BaseDatos.getDatabase(this, applicationScope) }
    val miRepositorio by lazy { Repositorio(database.miDAO()) }
}