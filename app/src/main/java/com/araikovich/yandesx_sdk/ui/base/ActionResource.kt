package com.araikovich.yandesx_sdk.ui.base

import androidx.lifecycle.MutableLiveData

data class ActionResource<out T>(
    val state: ActionState,
    val data: T? = null,
    val error: ActionError? = null,
) {

    companion object {
        fun <T> success(data: T): ActionResource<T> {
            return ActionResource(state = ActionState.SUCCESS, data, error = null)
        }

        fun <T> error(
            data: T? = null,
            errorMessage: String = "",
            code: Int = 0
        ): ActionResource<T> {
            return ActionResource(
                state = ActionState.ERROR,
                data,
                error = ActionError(errorMessage, code)
            )
        }
    }
}

data class ActionError(
    val message: String?,
    val code: Int,
)

fun <T> MutableLiveData<ActionResource<T>>.success(data: T) {
    value = ActionResource.success(data)
}

fun <T> MutableLiveData<ActionResource<T>>.error(message: String, code: Int = 0) {
    value = ActionResource.error(null, message, code)
}

fun <T> MutableLiveData<ActionResource<T>>.loading(isRemote: Boolean) {
    value = ActionResource(ActionState.LOADING(isRemote), null, null)
}

//Progress delegate can be added
fun <T> ActionResource<T>.doOnResult(
    onLoading: ((isRemote: Boolean) -> Unit)? = null,
    onSuccess: ((T) -> Unit)? = null,
    onError: ((errorDescription: String, data: T?) -> Unit)? = null,
    onFinish: (() -> Unit)? = null,
    onEmpty: (() -> Unit)? = null
) {
    when (state) {
        is ActionState.LOADING -> {
            onLoading?.invoke(state.isRemote)
        }
        is ActionState.SUCCESS -> {
            data?.also {
                onSuccess?.invoke(it)
            } ?: onError?.invoke("", data)
            onFinish?.invoke()
        }
        is ActionState.ERROR -> {
            val errorTextMessage = error?.message ?: ""
            onError?.invoke(errorTextMessage, data)
            onFinish?.invoke()
        }
        ActionState.EMPTY -> {
            onEmpty?.invoke()
            onFinish?.invoke()
        }
    }
}

sealed class ActionState {

    class LOADING(val isRemote: Boolean) : ActionState()

    object EMPTY : ActionState()

    object SUCCESS : ActionState()

    object ERROR : ActionState()
}