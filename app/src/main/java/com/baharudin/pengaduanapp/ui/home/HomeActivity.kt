package com.baharudin.pengaduanapp.ui.home

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.baharudin.pengaduanapp.R
import com.baharudin.pengaduanapp.data.utils.AppActivity
import com.baharudin.pengaduanapp.data.utils.HasObservers
import com.baharudin.pengaduanapp.data.utils.HasViews
import com.baharudin.pengaduanapp.data.utils.loadFile
import com.baharudin.pengaduanapp.databinding.ActivityHomeBinding
import com.baharudin.pengaduanapp.ui.success.SuccesActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.ImagePickerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppActivity<ActivityHomeBinding, HomeViewModel>
    (R.layout.activity_home), HasViews, HasObservers {

    override val viewModel by viewModels<HomeViewModel>()

    override fun setupObservers() {
        viewModel.successOrdering.observe(this) {
            viewModel.showAlertMessageEvent
            startActivity(Intent(this, SuccesActivity::class.java))
            finish()
        }
        viewModel.launchImagePicker.observe(this) {
            Log.w("PIC","123")
            ImagePicker
                .with(this)
                .cropSquare()
                .start(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            val imageFile = ImagePicker.getFile(data)
            if (imageFile != null) {
                Log.d("TAGGG","$imageFile")
                viewModel.fotoLaporan.value = imageFile
                viewBinding.imvPhoto.loadFile(imageFile)
            }
        }
    }

    override fun setupViews() {
    }
    companion object {
        const val IMAGE_REQUEST_CODE = 1000

    }

}