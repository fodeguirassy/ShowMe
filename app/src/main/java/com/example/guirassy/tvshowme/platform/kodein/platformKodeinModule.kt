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
    bind<Retrofit>() with singleton { buildRetrofitClient(instance()) }
    bind<TVMazeApiInterface>() with singleton { buildTVMazeApiInterface(instance()) }
    bind<TVMazeApiService>() with singleton { TVMazeApiService(instance()) }

}