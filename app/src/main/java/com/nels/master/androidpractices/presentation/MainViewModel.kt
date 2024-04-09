package com.nels.master.androidpractices.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nels.master.androidpractices.Cons
import com.nels.master.androidpractices.domain.usecases.GetDarkTheme
import com.nels.master.androidpractices.domain.usecases.PutDarkTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDarkTheme: GetDarkTheme,
    private val putDarkTheme: PutDarkTheme
) : ViewModel() {

    private val TAG =  "MainViewModel"
    init {
        getDarkThemeValue()
    }

    var state by mutableStateOf(MainState())
        private set

    fun onEvent(e: MainEvent) {
        when (e) {
            is MainEvent.SaveDarkThemeValue -> saveTheme(state.darkMode)
            is MainEvent.SelectedDarkThemeValues -> {
                Log.d(TAG,"SelectedDarkThemeValues")
                state =  state.copy(darkMode = e.value)
            }
        }
    }

    private fun saveTheme(value: Boolean) {
        viewModelScope.launch {
            Log.d(TAG,"saveTheme()")
            putDarkTheme(Cons.DARK_THEME_KEY, value)
        }
    }

    private fun getDarkThemeValue() {
        viewModelScope.launch {
            val res = getDarkTheme(Cons.DARK_THEME_KEY)
            res?.let {
                state = state.copy(darkMode = it)
            }
        }
    }

}