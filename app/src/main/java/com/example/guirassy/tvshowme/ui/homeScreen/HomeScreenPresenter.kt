package com.example.guirassy.tvshowme.ui.homeScreen

import android.support.annotation.MainThread
import com.ekino.mvp.MvpPresenter
import com.example.guirassy.tvshowme.model.TVMazeObject
import com.example.guirassy.tvshowme.navigation.Navigator
import com.example.guirassy.tvshowme.platform.TVMazeApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlinx.android.synthetic.main.fragment_home_screen.*

class HomeScreenPresenter(view: HomeScreenContract.View, navigator: Navigator, val tvMazeApiService: TVMazeApiService) :
        MvpPresenter<Navigator, HomeScreenContract.View>(view, navigator),
        HomeScreenContract.Presenter {


    private lateinit var subscriptions : CompositeDisposable

    override fun cleanRawApiResponse(shows: List<TVMazeObject>?): List<TVMazeObject> {

        shows?.let {
            return shows
                    .filter ({ true })
        }
        return emptyList()
    }

    override fun pickARandomChar(): String {
        val characters = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
                "p","q","r","s","t","u","v","w","x","y","z")
        var random = Random()
        val index = random.nextInt(characters.size)
        return characters[index]
    }

    override fun onFragmentLaunched() {
        //collection that helps handling device orientation change
        //while request is processing ---> labeled as good pratice
        subscriptions = CompositeDisposable()

        val randomChar = pickARandomChar()
        val subscription = tvMazeApiService.searchForShows(randomChar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listOfShows ->
                    view?.let {
                        it.setShowsInCarousel(listOfShows.filter {
                            it.show != null && it.show.image.medium != null
                        })
                    }
                }, { e ->
                    println("TESTTT $e")
                })
        subscriptions.add(subscription)
    }

    override fun resume() {
        super.resume()
    }

    override fun pause() {
        super.pause()
        subscriptions.clear()
    }

}
