package com.araikovich.yandesx_sdk.ui.restaurant_list

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.araikovich.yandesx_sdk.databinding.ViewHolderRestaurantBinding
import com.araikovich.yandesx_sdk.ui.base.loadRestaurantImage
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem

class RestaurantItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewHolderRestaurantBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(item: RestaurantViewItem) {
        binding.ivRestaurant.loadRestaurantImage(item.imageSrc)
        binding.tvDeliveryPrice.text = item.deliveryPrice.toString()
        binding.tvRestaurantName.text = item.name
        binding.tvDeliveryTime.text = item.timeForDelivery.toString()
    }
}