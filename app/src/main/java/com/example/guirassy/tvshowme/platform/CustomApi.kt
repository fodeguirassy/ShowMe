package com.example.guirassy.tvshowme.platform

import com.example.guirassy.tvshowme.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * CustomApi -
 * @author guirassy
 * @version $Id$
 */
interface CustomApi {
    @GET("user/")
    fun getUserById(@Query("id") id : String) : Single<User>
}