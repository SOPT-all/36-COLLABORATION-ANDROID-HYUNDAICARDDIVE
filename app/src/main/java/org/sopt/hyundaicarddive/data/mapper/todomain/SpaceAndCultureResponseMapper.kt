package org.sopt.hyundaicarddive.data.mapper.todomain

import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceAndCultureResponseDto
import org.sopt.hyundaicarddive.data.remote.dto.response.WhatsOnListDto
import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData

fun SpaceAndCultureResponseDto.toDomain(): List<SpaceAndCultureWhatsOnData> = dataList.map { it.toDomain() }

fun WhatsOnListDto.toDomain(): SpaceAndCultureWhatsOnData = SpaceAndCultureWhatsOnData(
    date = this.date,
    title = this.title,
    description = this.description,
    stage = this.stage,
    location = this.location,
    isReservable = this.isReservable,
    imageUrl = this.imageUrl
)
