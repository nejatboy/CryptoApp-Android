package com.loodos.cryptoapp.util

import android.content.res.Resources

object Device {

    private val displayMetrics = Resources.getSystem().displayMetrics

    val width get() = displayMetrics.widthPixels
    val height get() = displayMetrics.heightPixels

    val Float.widthRatio: Int get() = (Device.width * this).toInt()
    val Float.heightRatio: Int get() = (Device.height * this).toInt()
}