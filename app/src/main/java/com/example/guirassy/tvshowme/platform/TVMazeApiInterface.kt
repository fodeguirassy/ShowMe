package com.example.guirassy.tvshowme.platform

import com.example.guirassy.tvshowme.model.TVMazeObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TVMazeApiInterface -
 * @author guirassy
 * @version $Id$
 */
interface TVMazeApiInterface {
    @GET("search/shows")
    fun getShowsByChar(@Query("q") char: String) : Observable<List<TVMazeObject>>
}