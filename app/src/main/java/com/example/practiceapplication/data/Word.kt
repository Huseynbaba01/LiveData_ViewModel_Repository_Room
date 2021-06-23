package com.example.practiceapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "word")
    val value:String
)