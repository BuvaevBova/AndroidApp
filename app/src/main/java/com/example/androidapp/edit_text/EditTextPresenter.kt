package com.example.androidapp.edit_text

import com.example.androidapp.base.BasePresenter

class EditTextPresenter : BasePresenter<EditTextFragment>() {
    fun onLoginBtnClick(login: String, password: String) {
        //бизнес логика.
        view?.loginSuccess()
        view?.showLogin(login)
        view?.showPassword(password)
    }
}