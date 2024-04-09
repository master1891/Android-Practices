package com.nels.master.androidpractices.data.source.preferences

interface Preferences{
    suspend fun putDarkThemeValue(key: String, value: Boolean)
    suspend fun getDarkValueTheme(key: String): Boolean?
}