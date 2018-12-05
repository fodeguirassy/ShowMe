package com.example.guirassy.tvshowme.model.kodein

import com.example.guirassy.tvshowme.model.*
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider

/**
 * modelKodeinModule -
 * @author guirassy
 * @version $Id$
 */

/*
val modelKodeinModule = Kodein.Module {

    bind<Rating>() with provider { Rating(instance()) }
    bind<Show>() with provider {
        Show(instance(), instance(), instance(),
                instance(), instance(), instance(), instance(), instance(), instance(), instance(),
                instance(), instance(), instance(), instance(), instance())
    }
    bind<Schedule>() with provider { Schedule(instance(), instance()) }
    bind<Image>() with provider { Image(instance(), instance()) }
    bind<TVMazeObject>() with provider { TVMazeObject(instance(), instance()) }

}
        */