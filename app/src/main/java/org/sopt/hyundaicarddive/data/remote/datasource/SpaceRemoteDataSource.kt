package org.sopt.hyundaicarddive.data.remote.datasource

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceResponseDto

interface SpaceRemoteDataSource {
    suspend fun getSpace(): BaseResponse<SpaceResponseDto>
}
