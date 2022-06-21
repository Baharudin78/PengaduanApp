package com.baharudin.pengaduanapp.data.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class AppViewModel : ViewModel() {

    val loading by lazy { MutableLiveData(false) }

    protected val _showToastMessageEvent by lazy { MutableLiveEvent<String>() }
    val showToastMessageEvent: LiveEvent<String> = _showToastMessageEvent

    protected val _showConfirmationMessageEvent by lazy { MutableLiveEvent<Pair<String, () -> Unit>>() }
    val showConfirmationMessageEvent: LiveEvent<Pair<String, () -> Unit>> = _showConfirmationMessageEvent

    protected val _showAlertMessageEvent by lazy { MutableLiveEvent<Pair<String, () -> Unit>>() }
    val showAlertMessageEvent: LiveEvent<Pair<String, () -> Unit>> = _showAlertMessageEvent

    protected var mDefaultConfirmationMessage = "Are you sure?"

//    protected fun showToast(message: String?) {
//        _showToastMessageEvent.set(message.orEmpty())
//    }

//    protected fun showMessage(message: String?, nextAction: () -> Unit = {}) {
//        showToast(message)
//        nextAction()
//    }
//
//    protected fun showFailureMessage(message: String?, nextAction: () -> Unit = {}) {
//        showToast(message)
//        nextAction()
//    }
//
//    protected fun showFailureMessage(exception: Exception?, nextAction: () -> Unit = {}) {
//        showToast(exception?.message)
//        nextAction()
//    }
//
//    protected fun showConfirmationMessage(message: String?, onConfirmed: () -> Unit = {}) {
//        _showConfirmationMessageEvent.set(Pair(message ?: mDefaultConfirmationMessage, onConfirmed))
//    }
//
//    protected fun showAlertMessage(message: String, onConfirmed: () -> Unit = {}) {
//        _showAlertMessageEvent.set(Pair(message, onConfirmed))
//    }
}