package org.sopt.hyundaicarddive.data.mapper.todomain

import org.sopt.hyundaicarddive.data.remote.dto.response.DummyResponseDto
import org.sopt.hyundaicarddive.domain.model.DummyData

fun DummyResponseDto.toDomain(): DummyData {
    return DummyData(
        description = this.dummy + "입니다 "
    )
}