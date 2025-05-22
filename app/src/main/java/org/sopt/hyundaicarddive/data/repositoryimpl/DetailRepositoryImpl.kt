package org.sopt.hyundaicarddive.data.repositoryimpl

import org.sopt.hyundaicarddive.data.mapper.todomain.toDomain
import org.sopt.hyundaicarddive.data.remote.datasource.DetailRemoteDataSource
import org.sopt.hyundaicarddive.domain.model.DetailData
import org.sopt.hyundaicarddive.domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource
) : DetailRepository {
    override suspend fun getDetail(): Result<DetailData> = runCatching {
        detailRemoteDataSource.getDetail().data?.toDomain() ?: DetailData(
            address = "",
            operationTime = "",
            articleList = emptyList()
        )
    }
}
