package com.araikovich.sdk_showcase

import android.view.View

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun showViews(vararg views: View) {
    for (view in views) {
        view.show()
    }
}