package org.sopt.hyundaicarddive.data.remote.service

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceResponseDto
import retrofit2.http.GET

interface SpaceService {
    @GET("/api/space/details")
    suspend fun getSpace(): BaseResponse<SpaceResponseDto>
}
