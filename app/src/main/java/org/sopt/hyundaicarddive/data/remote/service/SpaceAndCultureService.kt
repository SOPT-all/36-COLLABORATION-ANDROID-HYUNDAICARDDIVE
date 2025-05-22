package org.sopt.hyundaicarddive.data.remote.service

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceAndCultureResponseDto
import retrofit2.http.GET

interface SpaceAndCultureService {
    @GET("/api/culture")
    suspend fun getWhatsOn(): BaseResponse<SpaceAndCultureResponseDto>
}
