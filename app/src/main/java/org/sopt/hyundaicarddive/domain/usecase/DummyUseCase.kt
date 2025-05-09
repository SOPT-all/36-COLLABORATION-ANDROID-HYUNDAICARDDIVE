package org.sopt.hyundaicarddive.domain.usecase

import org.sopt.hyundaicarddive.domain.model.DummyData
import org.sopt.hyundaicarddive.domain.repository.DummyRepository
import javax.inject.Inject

class DummyUseCase @Inject constructor(
    private val dummyRepository: DummyRepository
) {
    suspend operator fun invoke(): Result<DummyData> = dummyRepository.dummy()
}