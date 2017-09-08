package com.example.guirassy.tvshowme.ui

import com.example.guirassy.tvshowme.ui.util.ErrorDisplay
import com.github.salomonbrys.kodein.*

/**
 * uiKodeinModule -
 * @author guirassy
 * @version $Id$
 */

val uiKodeinModule = Kodein.Module {
    bind() from singleton { ErrorDisplay(instance()) }
    bind<HomeScreenContract.Presenter>() with provider { HomeScreenPresenter(instance(), instance(), instance()) }
}

