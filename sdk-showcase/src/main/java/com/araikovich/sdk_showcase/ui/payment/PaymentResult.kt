package com.araikovich.sdk_showcase.ui.payment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentResult(
    val message: String,
    val resultToken: String
) : Parcelable