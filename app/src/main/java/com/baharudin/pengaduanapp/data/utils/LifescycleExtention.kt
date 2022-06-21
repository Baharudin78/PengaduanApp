package com.baharudin.pengaduanapp.data.utils

import androidx.lifecycle.MutableLiveData

fun <T> MutableList<T>.replaceFirst(newItem: T, predicate: (item: T) -> Boolean): MutableList<T> {
    val index = indexOfFirst { predicate(it) }
    removeAt(index)
    add(index, newItem)
    return this
}

@JvmName("mutateMutableList")
inline fun <E, reified T : MutableList<E>> MutableLiveData<T>.mutateList(
    newItem: E,
    noinline predicate: (item: E) -> Boolean
) {
    value = value?.replaceFirst(newItem, predicate) as T
}

@JvmName("mutateList")
inline fun <E, reified T : List<E>> MutableLiveData<T>.mutateList(
    newItem: E,
    noinline predicate: (item: E) -> Boolean
) {
    value = value?.toMutableList()?.replaceFirst(newItem, predicate)?.toList() as T
}

@JvmName("addToList")
inline fun <E, reified T : List<E>> MutableLiveData<T>.add(newItem: E) {
    value = value?.toMutableList()?.apply { add(newItem) } as T
}

fun MutableLiveData<Boolean>.toggle() {
    value = !(value ?: false)
}

fun MutableLiveData<Boolean>.toTrue() {
    value = true
}

fun MutableLiveData<Boolean>.toFalse() {
    value = false
}