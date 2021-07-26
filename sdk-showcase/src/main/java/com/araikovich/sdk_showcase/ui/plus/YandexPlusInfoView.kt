package com.araikovich.sdk_showcase.ui.plus

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.araikovich.sdk_showcase.R
import com.araikovich.sdk_showcase.databinding.ViewYandexPlusBonusCountBinding
import com.araikovich.sdk_showcase.hide
import com.araikovich.sdk_showcase.showViews

@SuppressLint("InflateParams")
class YandexPlusInfoView(context: Context, attributesSet: AttributeSet) :
    FrameLayout(context, attributesSet) {

    private var binding: ViewYandexPlusBonusCountBinding

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_yandex_plus_bonus_count, null)
        binding = ViewYandexPlusBonusCountBinding.bind(view)
        addView(view)
    }

    fun setupInfoModel(model: YandexPlusUserInfoModel, timeStart: Long) {
        with(binding){
            progress.hide()
            tvBonusCount.append(" ${model.bonusCount}")
            //Can setupData
            tvTimer.base = timeStart
            tvTimer.start()
            showViews(tvBonusCount, tvIsSaleAvailable, tvTimer)
        }
    }
}