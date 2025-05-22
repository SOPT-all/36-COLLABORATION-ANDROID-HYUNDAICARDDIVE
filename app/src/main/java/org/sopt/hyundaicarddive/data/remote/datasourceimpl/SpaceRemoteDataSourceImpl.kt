package org.sopt.hyundaicarddive.data.remote.datasourceimpl

import org.sopt.hyundaicarddive.data.remote.datasource.SpaceRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceResponseDto
import org.sopt.hyundaicarddive.data.remote.service.SpaceService
import javax.inject.Inject

class SpaceRemoteDataSourceImpl @Inject constructor(
    private val spaceService: SpaceService
) : SpaceRemoteDataSource {
    override suspend fun getSpace(): BaseResponse<SpaceResponseDto> =
        spaceService.getSpace()
}
