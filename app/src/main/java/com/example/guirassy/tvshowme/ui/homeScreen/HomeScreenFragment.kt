package com.example.guirassy.tvshowme.ui.homeScreen


import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.ekino.mvp.MvpFragment
import com.example.guirassy.tvshowme.R
import com.example.guirassy.tvshowme.model.TVMazeObject
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.SupportFragmentInjector
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.synnapps.carouselview.ImageListener

import kotlinx.android.synthetic.main.fragment_home_screen.view.*

class HomeScreenFragment : MvpFragment<HomeScreenContract.Presenter>(),
        HomeScreenContract.View, SupportFragmentInjector {

    override val injector = KodeinInjector()
    override val presenter: HomeScreenContract.Presenter by injector.instance()
    override val defaultLayout: Int = R.layout.fragment_home_screen

    var randomShows: List<TVMazeObject> = listOf()

    lateinit var imageListener : ImageListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()

        imageListener = ImageListener{
            position, imageView ->
            randomShows[position].show.image.medium?.let {
                Glide.with(view)
                        .load(randomShows[position].show.image.original)
                        .into(imageView)
            }
        }

       // view?.carousel_home?.setImageListener(imageListener)
    }

    override fun setShowsInCarousel(shows: List<TVMazeObject>) {
        shows?.let {
            randomShows = shows
            view?.carousel_home?.pageCount = randomShows.size
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter.onFragmentLaunched()

        view.carousel_home.setImageListener(imageListener)
        view.carousel_home.setImageClickListener{
            position ->
            println("Clicked show name is ${randomShows[position].show.name}")
        }

    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<HomeScreenContract.View>() with instance(this@HomeScreenFragment)
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()


    }
}
