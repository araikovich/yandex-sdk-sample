package com.araikovich.sdk_showcase.ui.payment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentParams(
    val token: String,
    val amount: String,
    val itemId: Int
): Parcelable