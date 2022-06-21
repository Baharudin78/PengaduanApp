package com.baharudin.pengaduanapp.data.utils

data class DataConfiguration(
    val remoteHost: String = "https://masyarakat-pengaduan.herokuapp.com/",
    val remoteTimeout: Long = 30,
    val prefsAlwaysCommit: Boolean = false,
    val debug: Boolean = true
)