package com.araikovich.yandesx_sdk

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.araikovich.sdk_showcase.Checkout
import com.araikovich.sdk_showcase.domain.YandexPlusInfoManager
import com.araikovich.sdk_showcase.ui.payment.PaymentParams
import com.araikovich.yandesx_sdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val manager = YandexPlusInfoManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupYandexView()
        setupListeners()
    }

    override fun onDestroy() {
        manager.unregisterAll()
        super.onDestroy()
    }

    private fun setupYandexView() {
        manager.registerView(binding.yandexView)
        manager.getYandexPlusInfo()
    }

    private fun setupListeners() {
        binding.yandexView.setOnActionButtonClick {
            startActivityForResult(
                Checkout.createPaymentIntent(
                    this,
                    PaymentParams("sfjslfd", "100$", 33)
                ), YANDEX_REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == YANDEX_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> showToken(data)
                Activity.RESULT_CANCELED -> showError()
            }
        }
    }

    private fun showToken(data: Intent?) {
        Checkout.createPaymentResult(data)?.also { result ->
            binding.tvResult.text = result.message
        }
    }

    private fun showError() {

    }

    companion object {
        private const val YANDEX_REQUEST_CODE = 1
    }
}