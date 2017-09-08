package com.example.guirassy.tvshowme.ui

import com.ekino.mvp.BasePresenter
import com.ekino.mvp.BaseView

interface HomeScreenContract {
    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter{
        fun onFragmentLaunched()
        fun pickARandomChar() : String
    }
}
