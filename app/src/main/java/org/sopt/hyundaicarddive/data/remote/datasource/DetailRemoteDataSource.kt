package org.sopt.hyundaicarddive.data.remote.datasource

import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.DetailResponseDto

interface DetailRemoteDataSource {

    suspend fun getDetail(): BaseResponse<DetailResponseDto>
}