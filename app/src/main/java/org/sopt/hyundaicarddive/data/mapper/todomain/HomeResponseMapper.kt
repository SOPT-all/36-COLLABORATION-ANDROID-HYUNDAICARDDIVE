package org.sopt.hyundaicarddive.data.mapper.todomain

import org.sopt.hyundaicarddive.data.remote.dto.response.CardListDto
import org.sopt.hyundaicarddive.data.remote.dto.response.HomeResponseDto
import org.sopt.hyundaicarddive.domain.model.HomeData

fun HomeResponseDto.toDomain(): List<HomeData> = cardList.map { it.toDomain() }

fun CardListDto.toDomain(): HomeData = HomeData(
    title = this.title,
    category = this.category,
    hashTag = this.hashTag,
    imageUrl = this.imageUrl
)
