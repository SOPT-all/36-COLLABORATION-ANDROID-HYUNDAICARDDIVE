package org.sopt.hyundaicarddive.domain.usecase

import org.sopt.hyundaicarddive.domain.model.DetailData
import org.sopt.hyundaicarddive.domain.repository.DetailRepository
import javax.inject.Inject

class DetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    suspend operator fun invoke(): Result<DetailData> = detailRepository.getDetail()
}