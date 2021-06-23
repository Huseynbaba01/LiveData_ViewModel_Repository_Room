package com.example.practiceapplication

abstract class Listener {
    abstract fun fill()
}
class Child{
    val listener= object: Listener() {
        override fun fill() {

        }
    }

    init {
        add(listener)
        add(object : Listener(){
            override fun fill() {

            }
        })
    }

    fun add(listen: Listener){

    }
}