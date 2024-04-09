package com.nels.master.androidpractices.domain

interface Repository{

    suspend fun putdarkThemeValue(key: String, value: Boolean)
    suspend fun getThemeValue(key: String):Boolean?
}