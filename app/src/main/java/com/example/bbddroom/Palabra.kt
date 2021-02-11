package com.example.bbddroom

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_palabras")
data class Palabra(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @NonNull @ColumnInfo (name = "palabra") val palabra: String = "") {}