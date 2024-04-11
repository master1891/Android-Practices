package com.nels.master.androidpractices.prototype


interface Animal {
    fun copy(): Animal
}

class Pajaro(private var name: String): Animal{

    override fun copy(): Animal {
       return Pajaro(name)
    }

}


