package org.sopt.hyundaicarddive.domain.repository

import org.sopt.hyundaicarddive.domain.model.SpaceData

interface SpaceRepository {
    suspend fun getSpace(): Result<SpaceData>
}