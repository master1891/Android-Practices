package com.nels.master.androidpractices.di

import android.content.Context
import com.nels.master.androidpractices.data.repository.RepositoryImpl
import com.nels.master.androidpractices.data.source.preferences.PreferenceImpl
import com.nels.master.androidpractices.data.source.preferences.Preferences
import com.nels.master.androidpractices.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    @Singleton
    @Provides
    fun providesPreferences(@ApplicationContext applicationContext: Context):Preferences{
        return PreferenceImpl(applicationContext)
    }

}