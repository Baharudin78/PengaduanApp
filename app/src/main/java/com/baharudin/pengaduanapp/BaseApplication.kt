package com.baharudin.pengaduanapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.baharudin.pengaduanapp.data.utils.CommonProvider
import com.baharudin.pengaduanapp.data.utils.DataConfiguration
import com.baharudin.pengaduanapp.data.network.DataProvider
import com.baharudin.pengaduanapp.data.utils.Util
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        Util.init(this)
        CommonProvider.init(BR.viewModel)
        DataProvider.init(
            this, DataConfiguration(
                remoteHost = "https://pengaduan-masyarakat.my.id/",
                remoteTimeout = 60L
            )
        )
    }
}