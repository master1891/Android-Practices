package com.nels.master.androidpractices.presentation

sealed class StatesUI(){
    object Precesing: StatesUI()
    object Loading: StatesUI()
    object Error: StatesUI()
    object Init: StatesUI()
}

//Sigleton
object RetrofitInstance {
    var name:String = "Nelson"
}

