package com.nels.master.androidpractices.domain.usecases

import com.nels.master.androidpractices.domain.Repository
import javax.inject.Inject

class GetDarkTheme @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(key:String):Boolean?{
        return repository.getThemeValue(key)
    }
}