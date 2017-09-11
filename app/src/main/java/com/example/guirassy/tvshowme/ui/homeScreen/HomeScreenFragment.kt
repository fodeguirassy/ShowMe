package com.example.guirassy.tvshowme.ui.homeScreen


import android.os.Bundle
import android.view.View
import com.example.guirassy.tvshowme.R
import com.ekino.mvp.MvpFragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.SupportFragmentInjector
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance

class HomeScreenFragment : MvpFragment<HomeScreenContract.Presenter>(),
        HomeScreenContract.View, SupportFragmentInjector {

    override val injector = KodeinInjector()
    override val presenter: HomeScreenContract.Presenter by injector.instance()
    override val defaultLayout: Int = R.layout.fragment_home_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
        presenter.onFragmentLaunched()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<HomeScreenContract.View>() with instance(this@HomeScreenFragment)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}
