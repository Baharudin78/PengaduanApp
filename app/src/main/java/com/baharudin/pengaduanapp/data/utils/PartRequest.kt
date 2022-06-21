package com.baharudin.pengaduanapp.data.utils

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

object PartRequest {

    @JvmStatic
    fun buildFileBody(file: File): RequestBody {
        return RequestBody.create(MediaType.parse("image/jpg"), file)
    }

    @JvmStatic
    fun buildTextBody(value: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), value)
    }

    @JvmStatic
    fun buildFilePart(file: File, name: String = "img"): MultipartBody.Part {
        val requestBody = RequestBody.create(MediaType.parse("image/jpg"), file)
        return MultipartBody.Part.createFormData(name, file.name, requestBody)
    }

    @JvmStatic
    fun buildTextPart(name: String, value: String): MultipartBody.Part {
        return MultipartBody.Part.createFormData(name, value)
    }

}