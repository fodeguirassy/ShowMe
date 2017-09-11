package com.example.guirassy.tvshowme.ui.homeScreen

import com.ekino.mvp.MvpPresenter
import com.example.guirassy.tvshowme.navigation.Navigator
import com.example.guirassy.tvshowme.platform.TVMazeApiService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class HomeScreenPresenter(view: HomeScreenContract.View, navigator: Navigator, val tvMazeApiService: TVMazeApiService) :
        MvpPresenter<Navigator, HomeScreenContract.View>(view, navigator),
        HomeScreenContract.Presenter {


    lateinit var subscriptions : CompositeDisposable


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

        val subscription = tvMazeApiService.searchForShows(pickARandomChar())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    listOfShows ->
                    println("TESTTT $listOfShows")
                }, { e ->
                    println("TESTTT $e")
                })

        subscriptions.add(subscription)
    }

    override fun resume() {
        super.resume()
        onFragmentLaunched()
    }

    override fun pause() {
        super.pause()
        subscriptions.clear()
    }

}
