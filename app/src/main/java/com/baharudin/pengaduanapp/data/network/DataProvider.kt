package com.baharudin.pengaduanapp.data.network

import android.app.Application
import android.content.Context
import com.baharudin.pengaduanapp.data.utils.DataConfiguration
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DataProvider {
    private lateinit var mApplicationContext: Application
    private lateinit var mDataConfiguration: DataConfiguration
    private lateinit var mApiService: ApiService

    @Synchronized
    fun init(app: Application, dataConfiguration: DataConfiguration = DataConfiguration()) {
        mApplicationContext = app
        mDataConfiguration = dataConfiguration
        mApiService =
            provideRetrofit(dataConfiguration).create(ApiService::class.java)
    }
    fun getContext(): Context {
        return mApplicationContext
    }

    fun getConfig(): DataConfiguration {
        return mDataConfiguration
    }

    fun getApiService(): ApiService {
        return mApiService
    }

    private fun provideRetrofit(config: DataConfiguration): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(config.remoteHost)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideRetrofitClient(config))
            .build()
    }
    private fun provideRetrofitClient(config: DataConfiguration): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(provideHttpLoggingInterceptor(config))
            .writeTimeout(config.remoteTimeout, TimeUnit.SECONDS)
            .readTimeout(config.remoteTimeout, TimeUnit.SECONDS)
            .build()
    }
    private fun provideHttpLoggingInterceptor(config: DataConfiguration): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (config.debug) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }
}