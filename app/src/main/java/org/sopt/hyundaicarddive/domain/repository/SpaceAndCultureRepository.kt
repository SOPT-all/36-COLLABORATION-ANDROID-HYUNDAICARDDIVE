package org.sopt.hyundaicarddive.domain.repository

import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData

interface SpaceAndCultureRepository {
    suspend fun getWhatsOn(): Result<List<SpaceAndCultureWhatsOnData>>
}