package com.nels.master.androidpractices.sigleton


//Patron Singleton
object MySingleton {

    //Existe cuando se llama
    val miAge by lazy { 21 }

    //Existe desde el inicio
    val myAge2 = 21

    abstract class Animal()

    fun myFunction(): Int {
        return  miAge
    }

}