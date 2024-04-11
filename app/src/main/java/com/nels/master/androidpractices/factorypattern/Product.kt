package com.nels.master.androidpractices.factorypattern

import android.util.Log

interface Product {
    fun doProduct()
}

class Jabon(name:String) : Product{

    private val TAG = "Jabon"
    override fun doProduct() {
        Log.d(TAG,"haciendo el jabon")
    }
}

class Escoba(name:String) : Product{

    private val TAG = "Escoba"
    override fun doProduct() {
        Log.d(TAG,"haciendo la escoba")
    }

}

object ProductFactory{
    fun crearProducto(name: String): Product?{
        return when(name){
            "jabon" -> Jabon(name)
            "escoba" -> Escoba(name)
            else -> null
        }
    }
}



