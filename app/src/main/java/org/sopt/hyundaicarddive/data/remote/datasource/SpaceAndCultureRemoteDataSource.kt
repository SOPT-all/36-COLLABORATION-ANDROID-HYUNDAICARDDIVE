package org.sopt.hyundaicarddive.data.remote.datasource

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceAndCultureResponseDto

interface SpaceAndCultureRemoteDataSource {
    suspend fun getWhatsOn(): BaseResponse<SpaceAndCultureResponseDto>
}