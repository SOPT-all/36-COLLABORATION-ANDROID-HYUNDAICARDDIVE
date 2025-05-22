package org.sopt.hyundaicarddive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.hyundaicarddive.data.remote.service.DetailService
import org.sopt.hyundaicarddive.data.remote.service.HomeService
import org.sopt.hyundaicarddive.data.remote.service.SpaceAndCultureService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)

    @Provides
    @Singleton
    fun providesDetailService(retrofit: Retrofit): DetailService =
        retrofit.create(DetailService::class.java)

    @Provides
    @Singleton
    fun providesSpaceAndCultureService(retrofit: Retrofit): SpaceAndCultureService =
        retrofit.create(SpaceAndCultureService::class.java)
}
