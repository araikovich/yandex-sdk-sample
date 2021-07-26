package com.araikovich.yandesx_sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.araikovich.sdk_showcase.domain.YandexPlusInfoManager
import com.araikovich.yandesx_sdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val manager = YandexPlusInfoManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager.registerView(binding.yandexView)
        manager.getYandexPlusInfo()
    }

    override fun onDestroy() {
        manager.unregisterAll()
        super.onDestroy()
    }
}