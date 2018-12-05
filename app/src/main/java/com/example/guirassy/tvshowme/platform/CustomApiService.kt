package com.example.guirassy.tvshowme.platform

import com.example.guirassy.tvshowme.model.User
import io.reactivex.Single

/**
 * CustomApiService -
 * @author guirassy
 * @version $Id$
 */
class CustomApiService(var customApi: CustomApi) {

    fun getUserById(id : String) : Single<User>{
        return customApi.getUserById(id)
    }


}