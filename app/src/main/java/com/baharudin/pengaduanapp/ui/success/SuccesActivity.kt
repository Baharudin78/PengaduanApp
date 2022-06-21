package com.baharudin.pengaduanapp.ui.success

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.pengaduanapp.R
import com.baharudin.pengaduanapp.databinding.ActivitySuccesBinding
import com.baharudin.pengaduanapp.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuccesActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySuccesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}