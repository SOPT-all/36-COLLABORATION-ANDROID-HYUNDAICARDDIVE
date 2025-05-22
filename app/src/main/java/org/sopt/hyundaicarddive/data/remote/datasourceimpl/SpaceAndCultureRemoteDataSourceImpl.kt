package org.sopt.hyundaicarddive.data.remote.datasourceimpl

import org.sopt.hyundaicarddive.data.remote.datasource.SpaceAndCultureRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.dto.base.BaseResponse
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceAndCultureResponseDto
import org.sopt.hyundaicarddive.data.remote.service.SpaceAndCultureService
import javax.inject.Inject

class SpaceAndCultureRemoteDataSourceImpl @Inject constructor(
    private val spaceAndCultureService: SpaceAndCultureService
) : SpaceAndCultureRemoteDataSource {
    override suspend fun getWhatsOn(): BaseResponse<SpaceAndCultureResponseDto> =
        spaceAndCultureService.getWhatsOn()
}
