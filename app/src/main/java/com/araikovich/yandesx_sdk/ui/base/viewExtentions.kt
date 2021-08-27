package com.araikovich.yandesx_sdk.ui.base

import android.content.Context
import android.content.res.Resources

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()