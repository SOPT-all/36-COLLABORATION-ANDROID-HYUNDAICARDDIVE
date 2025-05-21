package org.sopt.hyundaicarddive.data.remote.service

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.DetailResponseDto
import retrofit2.http.GET

interface DetailService {

    @GET("/api/space")
    suspend fun getDetail(): BaseResponse<DetailResponseDto>
}
