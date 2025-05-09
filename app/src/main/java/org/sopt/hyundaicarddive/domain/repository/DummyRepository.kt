package org.sopt.hyundaicarddive.domain.repository

import org.sopt.hyundaicarddive.domain.model.DummyData

interface DummyRepository{
    suspend fun dummy():Result<DummyData>
}