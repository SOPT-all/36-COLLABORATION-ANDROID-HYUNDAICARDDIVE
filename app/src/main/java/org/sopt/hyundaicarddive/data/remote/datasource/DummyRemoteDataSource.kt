package org.sopt.hyundaicarddive.data.remote.datasource

import org.sopt.hyundaicarddive.data.remote.dto.response.DummyResponseDto

interface DummyRemoteDataSource {
    suspend fun dummy(): DummyResponseDto
}
