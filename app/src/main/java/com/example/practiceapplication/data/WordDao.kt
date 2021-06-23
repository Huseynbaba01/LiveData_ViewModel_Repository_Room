package com.example.practiceapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface WordDao {
    @Query("SELECT * FROM my_table ORDER BY word ASC")
    suspend fun getAlphabetizedWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word:Word)

    @Query("DELETE FROM my_table WHERE id = :id")
    suspend fun delete(id:Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(words:List<Word>)

    @Query("DELETE FROM my_table")
    suspend fun deleteAll()

    @Query("DELETE FROM my_table WHERE id IN (:idList)")
    suspend fun deleteMultiple(idList:List<Int>)

    @Query("SELECT * FROM my_table WHERE word LIKE '%' || :search || '%'")
    suspend fun searchWords(search: String?): List<Word>
}