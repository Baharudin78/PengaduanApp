package com.baharudin.pengaduanapp.data.utils

class MutableLiveEvent<T> : LiveEvent<T>() {
    var value
        get() = action.value
        set(newValue) {
            action.postValue(newValue)
        }
    fun set(value: T) {
        this.value = ActionEvent(value)
    }
}