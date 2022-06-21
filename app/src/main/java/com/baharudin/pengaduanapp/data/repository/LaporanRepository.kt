package com.baharudin.pengaduanapp.data.repository

import com.baharudin.pengaduanapp.data.network.DataProvider
import com.baharudin.pengaduanapp.data.utils.IllegalRemoteResultException
import com.baharudin.pengaduanapp.data.utils.UnexpectedRepositoryResultException
import com.natpryce.Failure
import com.natpryce.Result
import com.natpryce.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

abstract class LaporanRepository : CoroutineScope {
    //suspend fun postLaporan(gambarLaporan : File, body : Laporan) : Response<LaporanResponse>
    override val coroutineContext : CoroutineContext = Dispatchers.IO

    protected fun getApi() = DataProvider.getApiService()

   inline fun <T> asDirectResult(block: () -> Response<T>) : Result<T, Exception>{
       try {
           val response = block()
           if (response.isSuccessful) {
               response.body()?.let { body -> return  Success(body) }
           }
           return Failure(IllegalRemoteResultException(response.message()))
       }catch (e : Exception) {
           return Failure(e)
       }
       return Failure(UnexpectedRepositoryResultException())
   }
}