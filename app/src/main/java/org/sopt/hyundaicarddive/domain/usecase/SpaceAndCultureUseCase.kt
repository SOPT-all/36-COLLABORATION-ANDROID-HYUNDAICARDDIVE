package org.sopt.hyundaicarddive.domain.usecase

import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData
import org.sopt.hyundaicarddive.domain.repository.SpaceAndCultureRepository
import javax.inject.Inject

class SpaceAndCultureUseCase @Inject constructor(
    private val spaceAndCultureRepository: SpaceAndCultureRepository
) {
    suspend operator fun invoke(): Result<List<SpaceAndCultureWhatsOnData>> = spaceAndCultureRepository.getWhatsOn()
}