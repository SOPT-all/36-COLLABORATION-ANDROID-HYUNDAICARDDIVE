package org.sopt.hyundaicarddive.data.remote.datasourceimpl

import jakarta.inject.Inject
import org.sopt.hyundaicarddive.data.remote.datasource.DummyRemoteDataSource
import org.sopt.hyundaicarddive.data.remote.dto.response.DummyResponseDto
import org.sopt.hyundaicarddive.data.remote.service.DummyService

class DummyRemoteDataSourceImpl @Inject constructor(
    private val service: DummyService
) : DummyRemoteDataSource {
    override suspend fun dummy(): DummyResponseDto =
        service.dummy()
}
