package org.sopt.hyundaicarddive.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.sopt.hyundaicarddive.data.repositoryimpl.HomeRepositoryImpl
import org.sopt.hyundaicarddive.data.repositoryimpl.SpaceAndCultureRepositoryImpl
import org.sopt.hyundaicarddive.domain.repository.HomeRepository
import org.sopt.hyundaicarddive.domain.repository.SpaceAndCultureRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun bindSpaceAndCultureRepository(spaceAndCultureRepositoryImpl: SpaceAndCultureRepositoryImpl): SpaceAndCultureRepository
}
