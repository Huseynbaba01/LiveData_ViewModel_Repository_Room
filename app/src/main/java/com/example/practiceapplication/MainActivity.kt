package com.example.practiceapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.practiceapplication.data.Word
import com.example.practiceapplication.data.WordApplication
import com.example.practiceapplication.data.WordViewModel
import com.example.practiceapplication.data.WordViewModelFactory
import com.example.practiceapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val wordViewModel: WordViewModel by viewModels {
            WordViewModelFactory((application as WordApplication).repository)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val text = binding.edittext.text.toString()
        binding.addbutton.setOnClickListener {
            val word = Word(0,binding.edittext.text.toString())
            if(word.value == "" || word.value.isBlank()){
                Toast.makeText(this,"Empty or null string",Toast.LENGTH_SHORT ).show()
            }
            else{
                wordViewModel.insert(word)
            }

        }
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            Log.d("TAG", "onCreate: $words")
            words?.let {
                try {
//                    binding.textview.text = it[it.size - 1].value
                    binding.textview.text = wordViewModel.allWords.value.toString()
                }catch (e:Exception){
                    Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        })
        binding.deletebutton.setOnClickListener {
            try{
            if(wordViewModel.allWords.value?.size!=0){val id = binding.edittext.text.toString().toInt()
            wordViewModel.delete(id)}
                else{
                    Toast.makeText(this,"Empty String",Toast.LENGTH_SHORT).show()
                }
            }catch ( e:NullPointerException ){
                Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
            }catch ( e:NumberFormatException ){
                Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
            }
        }
//        try {
//            // stuff
//        } catch (ex: Exception1) {
//            // Handle both exceptions
//        } catch (ex: Exception2) {
//        }
        binding.addlistbutton.setOnClickListener {
            val mutableList = mutableListOf<Word>()
            for( string in binding.edittext.text.toString().split(" ").toMutableList()){
                val word = Word(0,string)
                mutableList.add(word)
//                if(word.value == "" || word.value.isBlank()){wordViewModel.insert(word)
                }
                wordViewModel.insertAll(mutableList)
            }
        binding.deletelistbutton.setOnClickListener {
            if(binding.edittext.text.toString().split(" ").toMutableList().size!=2){
                Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show()
            }
            else{
                val a = binding.edittext.text.toString().split(" ").toMutableList()[0].toInt()
                val b = binding.edittext.text.toString().split(" ").toMutableList()[1].toInt()
                val list = mutableListOf<Int>()
                for(i in a..b){
                    list.add(i)
                }
                wordViewModel.deleteMultiple(list)
            }
        }
        binding.searchbutton.setOnClickListener {
            var string = binding.edittext.text.toString()
            if(string.isNullOrBlank()){
                Toast.makeText(this,"Invalid string",Toast.LENGTH_SHORT)
            }
            wordViewModel.searchWords(string)
//            string = wordViewModel.allWords.value.toString()
//            binding.textview.text = string
        }
        setContentView(binding.root)

    }
    /*fun toList(string:String):List<String>{
        return  string.split("\\s* \\s*")
    }*/
   /* fun showToast(toast: String?) {
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }*/


}
