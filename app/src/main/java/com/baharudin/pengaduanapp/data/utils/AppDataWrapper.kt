package com.baharudin.pengaduanapp.data.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.natpryce.Result
import com.natpryce.onFailure

class AppDataWrapper<T> {
    val liveData by lazy { MutableLiveData(listOf<T>()) }
    val isEmpty by lazy { Transformations.map(liveData) {it.isEmpty()} }
    val isLoading by lazy { MutableLiveData(false) }

    suspend fun load(block : suspend  ()-> Result<List<T>, Exception>) {
        isLoading.toTrue()
        val result = block().onFailure {
            isLoading.toFalse()
            return
        }
        isLoading.toFalse()
        liveData.value = result
    }
}