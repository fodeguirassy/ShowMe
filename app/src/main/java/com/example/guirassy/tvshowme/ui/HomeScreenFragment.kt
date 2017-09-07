package com.example.guirassy.tvshowme.ui


import com.example.guirassy.tvshowme.app.R
import com.ekino.android.mvp.MvpFragment

class HomeScreenFragment : MvpFragment<HomeScreenContract.Presenter>(),
        HomeScreenContract.View {
    override val defaultLayout: Int = R.layout.fragment_home_screen;
}
