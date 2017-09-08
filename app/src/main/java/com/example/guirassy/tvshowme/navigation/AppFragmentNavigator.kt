package com.example.guirassy.tvshowme.navigation

import android.content.Context
import android.support.v4.app.FragmentManager
import com.ekino.mvp.FragmentNavigator
import com.example.guirassy.tvshowme.ui.HomeScreenFragment
import com.example.guirassy.tvshowme.ui.HomeScreenPresenter
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.android.appKodein

/**
 * AppFragmentNavigator -
 * @author guirassy
 * @version $Id$
 */
class AppFragmentNavigator(context: Context, fragmentManager: FragmentManager, containerViewId : Int) :
        FragmentNavigator(context, fragmentManager, containerViewId),
        Navigator, KodeinAware {


    override val kodein = context.appKodein()

    override fun displayOrRestoreScreenOnActivityCreate(isAppInitialized: Boolean) {
        displayHomeScreen()
    }

    override fun displayHomeScreen() {
        val homeScreen = HomeScreenFragment()

        homeScreen.presenter.onFragmentLaunched()

        displayAndSetRootFragment(homeScreen)
    }
}