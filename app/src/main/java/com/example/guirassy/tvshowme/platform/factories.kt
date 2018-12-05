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

fun buildRetrofitClient(okHttpClient: OkHttpClient, url : String = "http://api.tvmaze.com/") : Retrofit {
    return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}

//"http://api.tvmaze.com/"
//http://10.98.145.18:8080/

fun buildRetrofitForCustomApi(okHttpClient: OkHttpClient, url : String = "http://10.98.145.18:8080/") :  Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
}

fun buildTVMazeApiService(retrofit: Retrofit) : TVMazeApiInterface {
    return retrofit.create(TVMazeApiInterface::class.java)
}

fun buildCustomApiService(retrofit: Retrofit) : CustomApi {
        return retrofit.create(CustomApi::class.java)
}

