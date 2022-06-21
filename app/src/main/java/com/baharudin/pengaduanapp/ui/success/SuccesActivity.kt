package com.baharudin.pengaduanapp.ui.success

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.pengaduanapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuccesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_succes)
    }
}