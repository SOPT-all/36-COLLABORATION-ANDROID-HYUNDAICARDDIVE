package org.sopt.hyundaicarddive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.hyundaicarddive.data.remote.service.DummyService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesDummyService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)
}