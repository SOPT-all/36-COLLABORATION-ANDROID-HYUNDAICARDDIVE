package org.sopt.hyundaicarddive.data.remote.service

import org.sopt.hyundaicarddive.data.remote.dto.response.DummyResponseDto
import retrofit2.http.GET

interface DummyService {
    @GET("/API")
    suspend fun dummy(): DummyResponseDto
}