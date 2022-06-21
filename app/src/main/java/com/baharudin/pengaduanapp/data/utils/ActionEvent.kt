package com.baharudin.pengaduanapp.data.utils

class ActionEvent<out T>(private val content: T) {

    var hasBeenUsed = false
        private set

    fun getContentIfNotUsed(): T? {
        return if (hasBeenUsed) null else {
            hasBeenUsed = true
            content
        }
    }

    fun peekContent(): T = content

}