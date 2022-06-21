package com.baharudin.pengaduanapp.data.utils

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class AppActivity<out T : ViewDataBinding, out V: AppViewModel>(resource : Int) :
    AppCompatActivity() {

    protected abstract val viewModel: V
    protected val viewBinding: T by lazy { DataBindingUtil.setContentView(this, resource) }

    protected open var confirmationPositiveButtonText: String = "OK"
    protected open var confirmationNegativeButtonText: String = "Cancel"

    private var mCanExit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this

        if (this is HasViewModel) viewBinding.setVariable(brViewModelId, viewModel)
        else { CommonProvider.getViewModelBindingId()?.let { id -> viewBinding.setVariable(id, viewModel) } }

        if (this is HasBindings) setupBinding()
        if (this is HasViewModel || this is HasBindings) viewBinding.executePendingBindings()

        // setup / preparation related
        if (this is HasViews) setupViews()
        if (this is HasObservers) setupObservers()

        setupDefaultObserver()

    }
    private fun setupDefaultObserver() {
        viewModel.showConfirmationMessageEvent.observe(this) {
            showAlertDialog(it.first, true, it.second)
        }
        viewModel.showAlertMessageEvent.observe(this) {
            showAlertDialog(it.first, false, it.second)
        }
    }
    private fun showAlertDialog(
        message: String,
        cancelable: Boolean = true,
        onConfirm: () -> Unit
    ) {
        AlertDialog
            .Builder(this)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton(confirmationPositiveButtonText) { dialog, _ ->
                onConfirm()
                dialog.dismiss()
            }

    }

}