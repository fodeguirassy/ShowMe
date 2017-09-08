package com.example.guirassy.tvshowme.ui.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

/**
 * ErrorDisplay -
 * @author guirassy
 * @version $Id$
 */
class ErrorDisplay (val context: Context) {

    fun showErrorMessage(message: String) {
        Handler(Looper.getMainLooper()).post({
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        })
    }

}