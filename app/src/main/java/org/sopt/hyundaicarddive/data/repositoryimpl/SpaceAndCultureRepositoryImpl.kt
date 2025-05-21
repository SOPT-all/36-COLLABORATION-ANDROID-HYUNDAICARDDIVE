package org.sopt.hyundaicarddive.data.repositoryimpl

import org.sopt.hyundaicarddive.data.mapper.todomain.toDomain
import org.sopt.hyundaicarddive.data.remote.datasource.SpaceAndCultureRemoteDataSource
import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData
import org.sopt.hyundaicarddive.domain.repository.SpaceAndCultureRepository
import javax.inject.Inject

class SpaceAndCultureRepositoryImpl @Inject constructor(
    private val spaceAndCultureRemoteDataSource: SpaceAndCultureRemoteDataSource,
) : SpaceAndCultureRepository {
    override suspend fun getWhatsOn(): Result<List<SpaceAndCultureWhatsOnData>> = runCatching {
        spaceAndCultureRemoteDataSource.getWhatsOn().data?.toDomain() ?: emptyList()
    }

}