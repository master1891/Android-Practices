package com.nels.master.androidpractices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewmodel: ViewModel(){

    fun getPokemons(){
        viewModelScope.launch {
            val res = RetrofitInstance.servicePokemon.getPokemons(23,1)
        }
    }


}