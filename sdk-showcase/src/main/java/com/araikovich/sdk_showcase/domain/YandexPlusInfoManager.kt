package com.araikovich.sdk_showcase.domain

import com.araikovich.sdk_showcase.YandexPlusComponent
import com.araikovich.sdk_showcase.ui.plus.YandexPlusInfoView
import com.araikovich.sdk_showcase.ui.plus.YandexPlusUserInfoModel
import kotlinx.coroutines.*
import javax.inject.Inject

class YandexPlusInfoManager {

    @Inject
    internal lateinit var getUserInfoUseCase: GetUserInfoUseCase

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private var infoView: YandexPlusInfoView? = null

    private var onSuccessCallback: ((YandexPlusUserInfoModel) -> Unit)? = null
    private var onErrorCallback: ((errorMessage: String) -> Unit)? = null

    init {
        YandexPlusComponent.moduleComponent?.inject(this)
    }

    fun registerView(view: YandexPlusInfoView) {
        infoView = view
    }

    fun registerCallback(
        onSuccess: (YandexPlusUserInfoModel) -> Unit,
        onError: (errorMessage: String) -> Unit
    ) {
        onSuccessCallback = onSuccess
        onErrorCallback = onError
    }

    fun getYandexPlusInfo() {
        coroutineScope.launch {
            val result = withContext(Dispatchers.IO) {
                getUserInfoUseCase.invoke(YandexPlusComponent.contract?.userId.orEmpty())
            }
            withContext(Dispatchers.Main) {
                onSuccessCallback?.invoke(result)
                infoView?.also { view ->
                    view.setupInfoModel(result, YandexPlusComponent.initTime)
                }
            }
        }
    }

    fun unregisterAll() {
        coroutineScope.coroutineContext.cancelChildren()
        onSuccessCallback = null
        onErrorCallback = null
    }
}