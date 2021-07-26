package com.araikovich.sdk_showcase.ui.payment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.araikovich.sdk_showcase.Checkout.PAYMENT_PARAMS
import com.araikovich.sdk_showcase.Checkout.PAYMENT_RESULT
import com.araikovich.sdk_showcase.databinding.ActivityYandexPaymentActivityBinding

class YandexPaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityYandexPaymentActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYandexPaymentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
        readIntent()
    }

    private fun setupListeners() {
        binding.btnConfirmPayment.setOnClickListener {
            createResultIntent()
            finish()
        }
    }

    private fun readIntent(){
        val data = intent.getParcelableExtra<PaymentParams>(PAYMENT_PARAMS)
        data?.also {
            binding.tvAmount.text = data.amount
        }
    }

    private fun createResultIntent() {
        val intent = Intent().putExtra(PAYMENT_RESULT, PaymentResult("result was success", "lsjfjggsd"))
        setResult(Activity.RESULT_OK, intent)
    }
}