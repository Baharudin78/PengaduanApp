package com.baharudin.pengaduanapp.data.model

data class LaporanResponse(
    val statusCode : Int,
    val message : String,
    val data : Laporan
)