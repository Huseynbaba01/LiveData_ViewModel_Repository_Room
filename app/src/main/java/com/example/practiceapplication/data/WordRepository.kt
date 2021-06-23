package com.example.practiceapplication.data

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.MutableStateFlow

class WordRepository(private val wordDao: WordDao) {

    var allWords:MutableStateFlow<List<Word>> = MutableStateFlow(arrayListOf())

    @WorkerThread
    suspend fun insert(word:Word){
        Log.i("INSERTING","CHECK")
        wordDao.insert(word)
        allWords.value = wordDao.getAlphabetizedWords()
    }
    @WorkerThread
    suspend fun delete(id:Int){
        wordDao.delete(id)
        allWords.value = wordDao.getAlphabetizedWords()
    }

    @WorkerThread
    suspend fun insertAll(words:List<Word>){
        wordDao.insertAll(words)
        allWords.value = wordDao.getAlphabetizedWords()

    }
    @WorkerThread
    suspend fun deleteAll(){
        wordDao.deleteAll()
    }
    @WorkerThread
    suspend fun deleteMultiple(list:List<Int>){
        wordDao.deleteMultiple(list)
    }
    @WorkerThread
    suspend fun searchWords(string:String){
        allWords.value = wordDao.searchWords(string)
//        Log.i("CHECK if null or not","true")
//        if(wordDao.searchWords().asLiveData().value?.size == 0){
//            Log.i("CHECK if null or not","true")
//        }
//        else{
//            Log.i("CHECK if null or not",wordDao.searchWords().asLiveData().value?.get(0).toString())
//        }
    }
}