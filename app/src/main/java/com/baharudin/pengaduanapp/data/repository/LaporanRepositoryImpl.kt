package com.baharudin.pengaduanapp.data.repository

import com.baharudin.pengaduanapp.data.model.Laporan
import com.baharudin.pengaduanapp.data.model.LaporanResponse
import com.baharudin.pengaduanapp.data.utils.PartRequest
import retrofit2.Response
import java.io.File

class LaporanRepositoryImpl : LaporanRepository() {
    suspend fun proceedLapor(fotoTerlapor : File , body : Laporan) : Response<LaporanResponse> =
        getApi().postPengaduan(
            PartRequest.buildTextPart("name", body.name.orEmpty()),
            PartRequest.buildTextPart("address", body.address.orEmpty()),
            PartRequest.buildTextPart("phone", body.phone.orEmpty()),
            PartRequest.buildTextPart("work_unit", body.work_unit.orEmpty()),
            PartRequest.buildTextPart("reported", body.reported.orEmpty()),
            PartRequest.buildTextPart("deed", body.deed.orEmpty()),
            PartRequest.buildFilePart(fotoTerlapor, "incident_photo")
        )
}