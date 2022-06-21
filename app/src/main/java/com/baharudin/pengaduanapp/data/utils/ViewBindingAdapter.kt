package com.baharudin.pengaduanapp.data.utils

import android.os.Build
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.baharudin.pengaduanapp.R
import java.io.File

@BindingAdapter("loadUrl")
fun ImageView.loadUrl(url: String? = null) {
    if (url == null) return
    load(url) {
        placeholder(R.drawable.common_img_placeholder)
        error(R.drawable.common_img_placeholder)
    }
}

@BindingAdapter("loadFile")
fun ImageView.loadFile(file: File? = null) {
    if (file == null) return
    load(file) {
        placeholder(R.drawable.common_img_placeholder)
        error(R.drawable.common_img_placeholder)
    }
}


