package com.araikovich.yandesx_sdk.data.base

import java.util.*

class Price(val amount: Double, val currency: String) {

    override fun toString(): String {
        return when (currency) {
            "UAH" -> "$amount грн."
            else -> ""
        }
    }
}

