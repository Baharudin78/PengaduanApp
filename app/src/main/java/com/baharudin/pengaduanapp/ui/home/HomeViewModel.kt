package com.baharudin.pengaduanapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.pengaduanapp.data.model.Laporan
import com.baharudin.pengaduanapp.data.repository.LaporanRepository
import com.baharudin.pengaduanapp.data.repository.LaporanRepositoryImpl
import com.baharudin.pengaduanapp.data.utils.AppDataWrapper
import com.baharudin.pengaduanapp.data.utils.AppViewModel
import com.baharudin.pengaduanapp.data.utils.LiveEvent
import com.baharudin.pengaduanapp.data.utils.MutableLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val laporanRepository: LaporanRepositoryImpl
): AppViewModel(){

    val laporanWrapper by lazy { AppDataWrapper<Laporan>() }

    private val _successOrdering by lazy { MutableLiveEvent<Unit>() }
    val successOrdering : LiveEvent<Unit> = _successOrdering

    private val _launchImagePicker by lazy { MutableLiveEvent<Int>() }
    val launchImagePicker : LiveEvent<Int> = _launchImagePicker

    private val _toastMessage by lazy { MutableLiveEvent<String>() }
    val toastMessage : LiveEvent<String> = _toastMessage

    val nama by lazy { MutableLiveData<String>() }
    val address by lazy { MutableLiveData<String>() }
    val phone by lazy { MutableLiveData<String>() }
    val reported by lazy { MutableLiveData<String>() }
    val workUnit by lazy { MutableLiveData<String>() }
    val deed by lazy { MutableLiveData<String>() }
    val fotoLaporan by lazy { MutableLiveData<File>() }

    fun openImagePicker(typePick: Int){
        _launchImagePicker.set(typePick)
    }

    fun submitReport() {
        Log.w("Steepp ------http----", "1")
        val sendReport = Laporan(
            name = nama.value.orEmpty(),
            address = address.value.orEmpty(),
            phone = phone.value.orEmpty(),
            reported = reported.value.orEmpty(),
            work_unit = workUnit.value.orEmpty(),
            deed = deed.value.orEmpty(),
        )
        proceedReport(sendReport)
    }

    private fun proceedReport(lapor : Laporan) {
        viewModelScope.launch {
            Log.w("TAG","1 ${nama.value}")
            Log.w("TAG","1 ${address.value}")
            Log.w("TAG","1 ${phone.value}")
            Log.w("TAG","1 ${reported.value}")
            Log.w("TAG","1 ${workUnit.value}")
            Log.w("TAG","1 ${deed.value}")
            Log.w("TAG","1 ${fotoLaporan.value}")
            val api = fotoLaporan.value?.let { laporanRepository.proceedLapor(it, lapor) }
            if (api?.code() == 200) {
                _successOrdering.set(Unit)
            }else {
                _showToastMessageEvent.set(api?.body()?.message ?: "Error Response")
                return@launch
            }
        }
    }
}