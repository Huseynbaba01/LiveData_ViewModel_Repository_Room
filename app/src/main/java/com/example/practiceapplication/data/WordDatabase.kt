package com.example.practiceapplication.data

import android.content.Context
import android.util.Log
import androidx.room.CoroutinesRoom
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Word::class),version = /*2*/1,exportSchema = false)
public abstract class WordDatabase:RoomDatabase() {
    abstract fun wordDao():WordDao

    companion object{
        @Volatile
        private var INSTANCE:WordDatabase?=null

        fun getDatabase(
            context:Context,
            scope:CoroutineScope
        ):WordDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "word_database"
                ).build()
                Log.i("Database created ","true")
                INSTANCE = instance
                instance
            }
        }
    }

}
