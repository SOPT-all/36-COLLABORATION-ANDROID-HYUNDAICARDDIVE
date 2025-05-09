package org.sopt.hyundaicarddive.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.hyundaicarddive.domain.repository.DummyRepository
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideDummyUseCase(
        dummyRepository: DummyRepository
    ): DummyUseCase = DummyUseCase(dummyRepository)
}