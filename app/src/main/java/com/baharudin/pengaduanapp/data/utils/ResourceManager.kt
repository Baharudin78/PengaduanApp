package com.baharudin.pengaduanapp.data.utils

import android.content.Context

class ResourceManager(private val mContext: Context) {

    fun getString(resId: Int): String {
        return mContext.getString(resId)
    }

    fun getStringFormatted(resId: Int, vararg args: Any): String {
        return mContext.getString(resId).format(args)
    }

}