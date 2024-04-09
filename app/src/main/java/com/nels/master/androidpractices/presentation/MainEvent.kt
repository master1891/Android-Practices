package com.nels.master.androidpractices.presentation

sealed class MainEvent {

    class SaveDarkThemeValue( val value: Boolean?): MainEvent()
    class SelectedDarkThemeValues( val value: Boolean): MainEvent()

}