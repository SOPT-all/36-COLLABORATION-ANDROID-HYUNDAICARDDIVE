package org.sopt.hyundaicarddive.data.remote.datasourceimpl

import org.sopt.hyundaicarddive.data.remote.datasource.DetailRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.DetailResponseDto
import org.sopt.hyundaicarddive.data.remote.service.DetailService
import javax.inject.Inject

class DetailRemoteDataSourceImpl @Inject constructor(
    private val detailService: DetailService
) : DetailRemoteDataSource {
    override suspend fun getDetail(): BaseResponse<DetailResponseDto> =
        detailService.getDetail()


}