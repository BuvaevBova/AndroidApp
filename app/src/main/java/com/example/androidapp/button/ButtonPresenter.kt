package com.example.androidapp.button

import com.example.androidapp.R
import com.example.androidapp.base.BasePresenter
import extension.toast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ButtonPresenter : BasePresenter<ButtonFragment>(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    fun onProgressButtonClick() {
        launch {
            view?.setProgressStateProgressButton(true)
            delay(3000)
            view?.setProgressStateProgressButton(false)
        }
    }

    fun onButtonDrawableClick() {
        view?.showToast()
    }
}