package com.nels.master.androidpractices.di

import com.nels.master.androidpractices.data.repository.RepositoryImpl
import com.nels.master.androidpractices.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(preferenceImpl: RepositoryImpl): Repository
}