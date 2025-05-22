package org.sopt.hyundaicarddive.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.hyundaicarddive.data.remote.datasource.DetailRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.datasource.HomeRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.datasource.SpaceAndCultureRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.datasourceimpl.DetailRemoteDataSourceImpl
import org.sopt.hyundaicarddive.data.remote.datasourceimpl.HomeRemoteDataSourceImpl
import org.sopt.hyundaicarddive.data.remote.datasourceimpl.SpaceAndCultureRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsHomeDataSource(homeRemoteDataSourceImpl: HomeRemoteDataSourceImpl): HomeRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsDetailDataSource(detailRemoteDataSourceImpl: DetailRemoteDataSourceImpl): DetailRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsSpaceAndCultureDataSource(spaceAndCultureRemoteDataSourceImpl: SpaceAndCultureRemoteDataSourceImpl): SpaceAndCultureRemoteDataSource
}
