package org.sopt.hyundaicarddive.domain.usecase

import org.sopt.hyundaicarddive.domain.model.SpaceData
import org.sopt.hyundaicarddive.domain.repository.SpaceRepository
import javax.inject.Inject

class SpaceUseCase @Inject constructor(
    private val spaceRepository: SpaceRepository
) {
    suspend operator fun invoke(): Result<SpaceData> = spaceRepository.getSpace()
}