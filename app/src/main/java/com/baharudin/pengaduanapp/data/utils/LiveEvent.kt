package com.baharudin.pengaduanapp.data.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

open class LiveEvent<T> {

    protected val action: MutableLiveData<ActionEvent<T>> = MutableLiveData()

    fun observe(lifecycleOwner: LifecycleOwner, callback: (data: T) -> Unit) {
        action.observe(lifecycleOwner, Observer {
            action.value?.let {
                if (!it.hasBeenUsed) {
                    callback(it.getContentIfNotUsed() ?: it.peekContent())
                }
            }
        })
    }

}