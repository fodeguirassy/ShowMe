package com.example.guirassy.tvshowme.ui.homeScreen

import com.ekino.mvp.BasePresenter
import com.ekino.mvp.BaseView
import com.example.guirassy.tvshowme.model.TVMazeObject
import com.example.guirassy.tvshowme.model.User

interface HomeScreenContract {
    interface View : BaseView<Presenter> {
        fun setShowsInCarousel(shows : List<TVMazeObject>)
    }

    interface Presenter : BasePresenter {
        fun onFragmentLaunched()
        fun pickARandomChar() : String
        fun cleanRawApiResponse(shows : List<TVMazeObject> ?) : List<TVMazeObject>
        fun getUserById(id : String) : User?
    }
}
