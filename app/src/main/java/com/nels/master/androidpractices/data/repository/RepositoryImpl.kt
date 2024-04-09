package com.nels.master.androidpractices.data.repository

import com.nels.master.androidpractices.data.source.preferences.Preferences
import com.nels.master.androidpractices.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val repositoryPreference: Preferences
): Repository {
    override suspend fun putdarkThemeValue(key: String, value: Boolean) {
        repositoryPreference.putDarkThemeValue(key, value)
    }
    override suspend fun getThemeValue(key: String): Boolean? {
        return repositoryPreference.getDarkValueTheme(key)
    }
}


