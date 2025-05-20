package org.sopt.hyundaicarddive.data.remote.datasourceimpl

import jakarta.inject.Inject
import org.sopt.hyundaicarddive.data.remote.datasource.HomeRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.HomeResponseDto
import org.sopt.hyundaicarddive.data.remote.service.HomeService

class HomeRemoteDataSourceImpl @Inject constructor(
    private val homeService: HomeService
) : HomeRemoteDataSource {
    override suspend fun getHome(
        sortOption: String,
        category: String
    ): BaseResponse<HomeResponseDto> =
        homeService.getHome(
            sortOption = sortOption,
            category = category
        )
}
