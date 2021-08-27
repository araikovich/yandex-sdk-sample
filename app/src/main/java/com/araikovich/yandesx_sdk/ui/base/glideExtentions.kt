package com.araikovich.yandesx_sdk.ui.base

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition


fun AppCompatImageView.loadRestaurantImage(imageSrc: String) {
    val options: RequestOptions = RequestOptions()
        .transform(RoundedCorners(8.px))
        .centerCrop()
    Glide.with(this)
        .load(imageSrc)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(options).into(this)
}