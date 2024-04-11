package com.nels.master.androidpractices.abstractfactory


interface SamsungPhone{
    fun makeSamsungPhone()
}

class SamsungS24 : SamsungPhone{

    private val TAG = "SamsungPhone"
    override fun makeSamsungPhone() {
        TODO("Not yet implemented")
    }
}

class SamsungS24Plus : SamsungPhone{
    override fun makeSamsungPhone() {
        TODO("Not yet implemented")
    }
}

class SamsungS24Ultra : SamsungPhone{
    override fun makeSamsungPhone() {
        TODO("Not yet implemented")
    }
}


interface IphoneDevice{
    fun makeIphonePhone()
}

class Iphone15: IphoneDevice{
    private val TAG = "Iphone15"
    override fun makeIphonePhone() {
        TODO("Not yet implemented")
    }
}

class Iphone15Pro: IphoneDevice{
    private val TAG = "Iphone15Pro"
    override fun makeIphonePhone() {
        TODO("Not yet implemented")
    }
}
class Iphone15ProMax: IphoneDevice{
    private val TAG = "Iphone15ProMax"
    override fun makeIphonePhone() {
        TODO("Not yet implemented")
    }
}

interface Devices{
    fun doIphone(name:String): IphoneDevice?
    fun doSamsung(name: String): SamsungPhone?
}

//Abstract factory
object FactoryDevices : Devices{
    override fun doIphone(name: String): IphoneDevice? {

        return when(name){
            "iphone15" -> Iphone15()
            "iphone15pro" -> Iphone15()
            "iphone15promax" -> Iphone15()
            else -> null
        }

    }
    override fun doSamsung(name: String): SamsungPhone? {

        return when(name){
            "s24" -> SamsungS24()
            "s24plus" -> SamsungS24Plus()
            "s24ultra" -> SamsungS24Ultra()
            else -> null
        }
    }

}














