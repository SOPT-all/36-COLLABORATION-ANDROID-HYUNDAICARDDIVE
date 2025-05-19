package org.sopt.hyundaicarddive.data.remote.service

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.HomeResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("/api/home")
    suspend fun getHome(
        @Query("sortOption") sortOption: String,
        @Query("category") category: String
    ): BaseResponse<HomeResponseDto>
}
