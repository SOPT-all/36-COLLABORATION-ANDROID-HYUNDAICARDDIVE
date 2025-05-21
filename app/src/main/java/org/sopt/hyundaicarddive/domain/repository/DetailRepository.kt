package org.sopt.hyundaicarddive.domain.repository

import org.sopt.hyundaicarddive.domain.model.DetailData

interface DetailRepository {
    suspend fun getDetail(): Result<DetailData>
}