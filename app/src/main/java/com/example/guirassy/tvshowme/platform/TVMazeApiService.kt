package com.example.guirassy.tvshowme.platform

import com.example.guirassy.tvshowme.model.TVMazeObject
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * TVMazeApiService -
 * @author guirassy
 * @version $Id$
 */
class TVMazeApiService (var tvMazeApiInterface: TVMazeApiInterface) {

    val subscriptions = CompositeDisposable()

    fun searchForShows(char : String) : Single<List<TVMazeObject>> {
        return tvMazeApiInterface.getShowsByChar(char)
                .subscribeOn(Schedulers.io())
    }
}