package com.baharudin.pengaduanapp.data.network

import com.baharudin.pengaduanapp.data.model.LaporanResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("api/input-pengaduan")
    suspend fun postPengaduan(
        @Part a1 : MultipartBody.Part,
        @Part a2 : MultipartBody.Part,
        @Part a3 : MultipartBody.Part,
        @Part a4 : MultipartBody.Part,
        @Part a5 : MultipartBody.Part,
        @Part a6 : MultipartBody.Part,
        @Part photo : MultipartBody.Part
    ) : Response<LaporanResponse>
}