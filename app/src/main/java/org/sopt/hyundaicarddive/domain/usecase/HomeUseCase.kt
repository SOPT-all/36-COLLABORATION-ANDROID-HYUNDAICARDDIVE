package org.sopt.hyundaicarddive.domain.usecase

import org.sopt.hyundaicarddive.domain.model.HomeData
import org.sopt.hyundaicarddive.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        sortOption: String,
        category: String
    ): Result<List<HomeData>> = homeRepository.getHome(
        sortOption = sortOption,
        category = category
    )
}
