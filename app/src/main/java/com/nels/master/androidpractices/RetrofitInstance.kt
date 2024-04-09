package com.nels.master.androidpractices

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    val clientOhHttp3 = OkHttpClient.Builder().
        addInterceptor(MyInterceptor()).
        addInterceptor(HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)).build()


    val servicePokemon = Retrofit.Builder().baseUrl(ApiService.URL_BASE)
        .client(clientOhHttp3)
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)


}