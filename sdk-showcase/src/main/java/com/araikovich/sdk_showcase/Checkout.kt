package com.araikovich.sdk_showcase

import android.content.Context
import android.content.Intent
import com.araikovich.sdk_showcase.ui.payment.PaymentParams
import com.araikovich.sdk_showcase.ui.payment.PaymentResult
import com.araikovich.sdk_showcase.ui.payment.YandexPaymentActivity

object Checkout {

    internal const val PAYMENT_PARAMS = "payment_params"
    internal const val PAYMENT_RESULT = "payment_result"

    fun createPaymentIntent(context: Context, paymentParams: PaymentParams): Intent {
        return Intent(context, YandexPaymentActivity::class.java)
            .putExtra(PAYMENT_PARAMS, paymentParams)
    }

    fun createPaymentResult(data: Intent?): PaymentResult? {
        return data?.getParcelableExtra(PAYMENT_RESULT)
    }
}