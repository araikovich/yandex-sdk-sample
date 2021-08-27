package com.araikovich.yandesx_sdk.ui.restaurant_list

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RestaurantItemsDecorator : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(
            0, TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                10f,
                view.context.resources.displayMetrics
            ).toInt(), 0, 0
        )
    }
}