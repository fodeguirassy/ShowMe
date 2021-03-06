package com.example.guirassy.tvshowme.platform

import com.example.guirassy.tvshowme.model.TVMazeObject
import io.reactivex.Observable

/**
 * TVMazeApiService -
 * @author guirassy
 * @version $Id$
 */
class TVMazeApiService (var tvMazeApiInterface: TVMazeApiInterface) {

    fun searchForShows(char : String) : Observable<List<TVMazeObject>> {
        return tvMazeApiInterface.getShowsByChar(char)
    }
}