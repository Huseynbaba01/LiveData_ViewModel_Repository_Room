package com.example.practiceapplication.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WordViewModel(private val repository:WordRepository):ViewModel() {
    val allWords: MutableLiveData<List<Word>> = repository.allWords.asLiveData() as MutableLiveData<List<Word>>
    fun insert(word:Word) = viewModelScope.launch {
        repository.insert(word)
    }
    fun delete(id:Int) = viewModelScope.launch {
        repository.delete(id)
    }

    fun insertAll(words:List<Word>) = viewModelScope.launch{
        repository.insertAll(words)
    }
    /*fun deleteAll() = viewModelScope.launch{
        repository.deleteAll()
    }*/
    fun deleteMultiple(list:List<Int>) = viewModelScope.launch{
        repository.deleteMultiple(list)
    }
    fun searchWords(string:String) = viewModelScope.launch{
        repository.searchWords(string)
    }
}

@Suppress("UNCHECKED_CAST")
class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)){
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}