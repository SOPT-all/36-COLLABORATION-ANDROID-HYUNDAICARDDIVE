package org.sopt.hyundaicarddive.domain.usecase

import javax.inject.Inject
import org.sopt.hyundaicarddive.domain.model.DummyData
import org.sopt.hyundaicarddive.domain.repository.DummyRepository

class DummyUseCase @Inject constructor(
    private val dummyRepository: DummyRepository
) {
    suspend operator fun invoke(): Result<DummyData> = dummyRepository.dummy()
}
