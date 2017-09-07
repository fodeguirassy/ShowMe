package com.example.guirassy.tvshowme.model

/**
 * Show -
 * @author guirassy
 * @version $Id$
 */
class Show (var id : String, var url : String, var name : String,
            var type : String, var language : String, var genres : List<String>,
            var status : String, var runtime : String, var premiered : String,
            var officialSite : String, var summary : String, var updated : String,
            var schedule: Schedule, var rating: Rating, var image: Image)