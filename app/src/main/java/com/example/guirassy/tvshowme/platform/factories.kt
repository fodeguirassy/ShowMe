package com.example.guirassy.tvshowme.platform

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * factories -
 * @author guirassy
 * @version $Id$
 */

fun buildHttOkClient() : OkHttpClient {
    return OkHttpClient.Builder()
            .build()
}

fun buildRetrofitClient(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}

fun buildTVMazeApiInterface(retrofit: Retrofit) : TVMazeApiInterface {
    return retrofit.create(TVMazeApiInterface::class.java)
}
