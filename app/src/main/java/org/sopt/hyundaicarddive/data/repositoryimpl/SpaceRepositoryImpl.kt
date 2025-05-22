package org.sopt.hyundaicarddive.data.repositoryimpl

import org.sopt.hyundaicarddive.data.mapper.todomain.toDomain
import org.sopt.hyundaicarddive.data.remote.datasource.SpaceRemoteDataSource
import org.sopt.hyundaicarddive.domain.model.SpaceData
import org.sopt.hyundaicarddive.domain.repository.SpaceRepository
import javax.inject.Inject

class SpaceRepositoryImpl @Inject constructor(
    private val spaceRemoteDataSource: SpaceRemoteDataSource,
) : SpaceRepository {
    override suspend fun getSpace(): Result<SpaceData> = runCatching {
        spaceRemoteDataSource.getSpace().data?.toDomain() ?: SpaceData(
            bannerUrl = "",
            introduction = "",
            address = "",
            reviewList = emptyList(),
            telephone = "",
            email = ""
        )
    }
}