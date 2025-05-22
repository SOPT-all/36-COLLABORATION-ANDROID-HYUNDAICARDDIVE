package org.sopt.hyundaicarddive.data.mapper.todomain

import org.sopt.hyundaicarddive.data.remote.dto.response.ReviewListDto
import org.sopt.hyundaicarddive.data.remote.dto.response.SpaceResponseDto
import org.sopt.hyundaicarddive.domain.model.SpaceData
import org.sopt.hyundaicarddive.domain.model.SpaceReviewData

fun SpaceResponseDto.toDomain(): SpaceData = SpaceData(
    bannerUrl = this.bannerUrl,
    introduction = this.introduction,
    address = this.address,
    reviewList = this.reviewList.map { it.toDomain() },
    telephone = this.telephone,
    email = this.email
)

fun ReviewListDto.toDomain(): SpaceReviewData = SpaceReviewData(
    imageUrl = this.imageUrl,
    reviewer = this.reviewer,
    likeCount = this.likeCount
)
