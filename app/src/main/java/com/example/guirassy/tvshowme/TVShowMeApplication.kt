package com.example.guirassy.tvshowme

import android.app.Application
import android.content.Context
import com.example.guirassy.tvshowme.model.kodein.modelKodeinModule
import com.example.guirassy.tvshowme.platform.kodein.platformKodeinModule
import com.example.guirassy.tvshowme.ui.uiKodeinModule
import com.github.salomonbrys.kodein.*

/**
 * TVShowMeApplication -
 * @author guirassy
 * @version $Id$
 */
class TVShowMeApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        //bind<Context>() with instance(applicationContext)
        import(modelKodeinModule)
        import(platformKodeinModule)
        import(uiKodeinModule)
    }

}