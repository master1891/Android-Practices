package com.nels.master.androidpractices.domain.util

import java.io.File
import javax.sql.DataSource

sealed class Resource<T>(val data: T? = null , val message:String? = null ) {
    class Success<T>(data : T?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data,message)

}



