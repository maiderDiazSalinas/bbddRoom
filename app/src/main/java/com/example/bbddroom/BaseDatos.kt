package com.example.bbddroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Palabra::class), version=1, exportSchema=false)
abstract class BaseDatos: RoomDatabase() {

    abstract fun miDAO(): PalabraDAO

    companion object {
        @Volatile
        private var INSTANCE: BaseDatos?=null

        fun getDatabase(context: Context, scope: CoroutineScope): BaseDatos {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}