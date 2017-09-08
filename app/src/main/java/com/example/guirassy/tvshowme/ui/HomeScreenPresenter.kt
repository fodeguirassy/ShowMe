package com.example.guirassy.tvshowme.ui

import com.example.guirassy.tvshowme.navigation.Navigator
import com.ekino.mvp.MvpPresenter
import com.example.guirassy.tvshowme.platform.TVMazeApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*

class HomeScreenPresenter(view: HomeScreenContract.View, navigator: Navigator, val tvMazeApiService: TVMazeApiService) :
        MvpPresenter<Navigator, HomeScreenContract.View>(view, navigator),
        HomeScreenContract.Presenter {


    override fun pickARandomChar(): String {
        val characters = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
                "p","q","r","s","t","u","v","w","x","y","z")
        var random = Random()
        val index = random.nextInt(characters.size)
        return characters[index]
    }

    override fun onFragmentLaunched() {
        tvMazeApiService.searchForShows(pickARandomChar())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    println("RESPONSE $it")
                },{
                    print("ERROR $it")
                })
    }
}
