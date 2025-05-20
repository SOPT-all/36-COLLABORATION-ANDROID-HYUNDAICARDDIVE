package org.sopt.hyundaicarddive.data.remote.datasource

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.HomeResponseDto

interface HomeRemoteDataSource {
    suspend fun getHome(
        sortOption: String,
        category: String
    ): BaseResponse<HomeResponseDto>
}
