package com.nels.master.androidpractices

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private var _nameState: MutableStateFlow<String> = MutableStateFlow("")
    val nameState get() = _nameState

    val TAG = "MainViewModel"
    fun changeName(newName:String){

        viewModelScope.launch {
            delay(1000)
            Log.d(TAG,"changeName()")
            _nameState.update {
                newName
            }
        }
    }

}