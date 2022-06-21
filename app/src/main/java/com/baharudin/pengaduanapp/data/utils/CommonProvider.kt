package com.baharudin.pengaduanapp.data.utils

object CommonProvider {

    private var mViewModelBindingId: Int? = null
    fun init(viewModelBindingId: Int) {
        mViewModelBindingId = viewModelBindingId
    }
    fun getViewModelBindingId() = mViewModelBindingId
}