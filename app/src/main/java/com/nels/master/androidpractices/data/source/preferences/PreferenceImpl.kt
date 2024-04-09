package com.nels.master.androidpractices.data.source.preferences

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject


private const val PREFERENCE_NAME = "DARK_THEME"

private val Context.dataStore by preferencesDataStore(name = PREFERENCE_NAME)
class PreferenceImpl @Inject constructor(
    private val context: Context
): Preferences {
    override suspend fun putDarkThemeValue(key: String, value: Boolean) {
        val preferenceKey = booleanPreferencesKey(key)

        context.dataStore.edit { preference ->
            preference[preferenceKey] = value
        }
    }

    override suspend fun getDarkValueTheme(key: String): Boolean? {

        return try {
            val preferenceKey = booleanPreferencesKey(key)
            val preference = context.dataStore.data.first()
            preference[preferenceKey]

        }catch (ex: Exception){
            ex.printStackTrace()
            null
        }
    }
}