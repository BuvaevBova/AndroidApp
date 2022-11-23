package com.example.androidapp.base

open class BasePresenter<V> {
    var view: V? = null

    fun attach(view: V) {
        this.view = view
    }

    fun detach() {
        view = null
    }

}