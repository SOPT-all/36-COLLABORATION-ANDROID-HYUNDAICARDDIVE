package org.sopt.hyundaicarddive.data.repositoryimpl

import jakarta.inject.Inject
import org.sopt.hyundaicarddive.data.mapper.todomain.toDomain
import org.sopt.hyundaicarddive.data.remote.datasource.DummyRemoteDataSource
import org.sopt.hyundaicarddive.domain.model.DummyData
import org.sopt.hyundaicarddive.domain.repository.DummyRepository


class DummyRepositoryImpl @Inject constructor(
    private val dummyRemoteDataSource: DummyRemoteDataSource
) : DummyRepository {
    override suspend fun dummy(): Result<DummyData> = runCatching {
        dummyRemoteDataSource.dummy().toDomain()
    }
}