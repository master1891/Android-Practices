package com.nels.master.androidpractices.domain.usecases

import com.nels.master.androidpractices.domain.Repository
import javax.inject.Inject

class PutDarkTheme @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(key:String,values:Boolean){
        repository.putdarkThemeValue(key,values)
    }

}