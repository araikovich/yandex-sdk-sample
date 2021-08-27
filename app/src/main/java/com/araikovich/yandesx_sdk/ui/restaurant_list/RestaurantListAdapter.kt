package com.araikovich.yandesx_sdk.ui.restaurant_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.araikovich.yandesx_sdk.R
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem

class RestaurantListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            RESTAURANT_ITEM_VIEW_TYPE -> RestaurantItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_holder_restaurant, parent, false
                )
            )
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RestaurantViewItem -> RESTAURANT_ITEM_VIEW_TYPE
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RestaurantItemViewHolder -> {
                (items[position] as? RestaurantViewItem)?.also { item -> holder.bind(item) }
            }
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    fun update(newItems: List<RestaurantViewItem>) {
        val diffUtilCallback = RestaurantItemDiffUtilCallback(items, newItems)
        val result = DiffUtil.calculateDiff(diffUtilCallback)
        items.clear()
        items.addAll(newItems)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    companion object {

        private const val RESTAURANT_ITEM_VIEW_TYPE = 1
    }
}