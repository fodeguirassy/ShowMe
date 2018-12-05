package com.example.guirassy.tvshowme.platform.kodein

import com.example.guirassy.tvshowme.platform.*
import com.github.salomonbrys.kodein.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * platformKodeinModule -
 * @author guirassy
 * @version $Id$
 */

val platformKodeinModule = Kodein.Module {

    bind<OkHttpClient>() with singleton { buildHttOkClient() }
    bind<TVMazeApiService>() with singleton { TVMazeApiService(instance()) }

    //"http://api.tvmaze.com/"
    //http://10.98.145.18:8080/

    bind<Retrofit>("TVMazeApi") with singleton { buildRetrofitClient(instance(), instance()) }
    bind<Retrofit>("CustomApi") with singleton { buildRetrofitForCustomApi(instance(), instance()) }





    bind<CustomApi>() with singleton { buildCustomApiService(instance("CustomApi")) }
    bind<TVMazeApiInterface>() with singleton { buildTVMazeApiService(instance("TVMazeApi")) }


    bind<CustomApiService>() with singleton { CustomApiService(instance()) }
}