package org.sopt.hyundaicarddive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.hyundaicarddive.domain.repository.DetailRepository
import javax.inject.Singleton
import org.sopt.hyundaicarddive.domain.repository.HomeRepository
import org.sopt.hyundaicarddive.domain.usecase.DetailUseCase
import org.sopt.hyundaicarddive.domain.repository.SpaceAndCultureRepository
import org.sopt.hyundaicarddive.domain.repository.SpaceRepository
import org.sopt.hyundaicarddive.domain.usecase.HomeUseCase
import org.sopt.hyundaicarddive.domain.usecase.SpaceAndCultureUseCase
import org.sopt.hyundaicarddive.domain.usecase.SpaceUseCase

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
    fun provideDetailUseCase(
        detailRepository: DetailRepository
    ): DetailUseCase = DetailUseCase(detailRepository)

    @Provides
    @Singleton
    fun provideSpaceAndCultureUseCase(
        spaceAndCultureRepository: SpaceAndCultureRepository
    ): SpaceAndCultureUseCase = SpaceAndCultureUseCase(spaceAndCultureRepository)

    @Provides
    @Singleton
    fun provideSpaceUseCase(
        spaceRepository: SpaceRepository
    ): SpaceUseCase = SpaceUseCase(spaceRepository)
}
