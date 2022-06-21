package com.baharudin.pengaduanapp.di

import com.baharudin.pengaduanapp.data.repository.LaporanRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class, ServiceComponent::class)
object AppModule {

    @Provides
    fun provideLaporanRepository() = LaporanRepositoryImpl()

}