package com.example.guirassy.tvshowme.platform

import com.example.guirassy.tvshowme.model.TVMazeObject
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TVMazeApiInterface -
 * @author guirassy
 * @version $Id$
 */
interface TVMazeApiInterface {
    @GET("search/show")
    fun getShowsByChar(@Query("q") char: String) : Single<List<TVMazeObject>>
}