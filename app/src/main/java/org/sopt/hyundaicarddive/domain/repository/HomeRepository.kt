package org.sopt.hyundaicarddive.domain.repository

import org.sopt.hyundaicarddive.domain.model.HomeData

interface HomeRepository {
    suspend fun getHome(
        sortOption: String,
        category: String
    ): Result<List<HomeData>>
}
