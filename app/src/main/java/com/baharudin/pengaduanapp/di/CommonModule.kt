package com.baharudin.pengaduanapp.di

import android.content.Context
import com.baharudin.pengaduanapp.data.utils.ResourceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {
    @Provides
    fun resourceManager(@ApplicationContext context : Context) : ResourceManager {
        return ResourceManager(context)
    }
}