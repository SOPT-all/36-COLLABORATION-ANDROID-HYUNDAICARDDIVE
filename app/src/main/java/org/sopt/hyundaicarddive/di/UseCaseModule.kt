package org.sopt.hyundaicarddive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.sopt.hyundaicarddive.domain.repository.HomeRepository
import org.sopt.hyundaicarddive.domain.repository.SpaceAndCultureRepository
import org.sopt.hyundaicarddive.domain.usecase.HomeUseCase
import org.sopt.hyundaicarddive.domain.usecase.SpaceAndCultureUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideHomeUseCase(
        homeRepository: HomeRepository
    ): HomeUseCase = HomeUseCase(homeRepository)

    @Provides
    @Singleton
    fun provideSpaceAndCultureUseCase(
        spaceAndCultureRepository: SpaceAndCultureRepository
    ): SpaceAndCultureUseCase = SpaceAndCultureUseCase(spaceAndCultureRepository)
}
