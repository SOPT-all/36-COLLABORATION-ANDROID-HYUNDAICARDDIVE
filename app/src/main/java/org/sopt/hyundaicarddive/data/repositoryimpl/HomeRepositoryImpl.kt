package org.sopt.hyundaicarddive.data.repositoryimpl

import jakarta.inject.Inject
import org.sopt.hyundaicarddive.data.mapper.todomain.toDomain
import org.sopt.hyundaicarddive.data.remote.datasource.HomeRemoteDataSource
import org.sopt.hyundaicarddive.domain.model.HomeData
import org.sopt.hyundaicarddive.domain.repository.HomeRepository

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getHome(
        sortOption: String,
        category: String
    ): Result<List<HomeData>> = runCatching {
        homeRemoteDataSource.getHome(
            sortOption = sortOption,
            category = category
        ).data?.toDomain() ?: emptyList()
    }
}
