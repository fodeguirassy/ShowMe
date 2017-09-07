package com.example.guirassy.tvshowme.ui

import com.example.guirassy.tvshowme.navigation.Navigator
import com.ekino.mvp.MvpPresenter

class HomeScreenPresenter(view: HomeScreenContract.View, navigator: Navigator) :
        MvpPresenter<Navigator, HomeScreenContract.View>(view, navigator),
        HomeScreenContract.Presenter {

}
