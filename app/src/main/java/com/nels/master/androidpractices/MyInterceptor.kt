package com.nels.master.androidpractices

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor{

    private val TAG = "MyInterceptor"
    override fun intercept(chain: Interceptor.Chain): Response {

        Log.d(TAG,"mi interceptor")

        return chain.proceed(chain.request())
    }
}