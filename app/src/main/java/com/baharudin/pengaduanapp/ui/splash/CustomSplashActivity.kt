package com.baharudin.pengaduanapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.baharudin.pengaduanapp.R
import com.baharudin.pengaduanapp.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val intentHome = Intent(this, HomeActivity::class.java)
            startActivity(intentHome)
            finishAffinity()
        }, 2000)
    }
}