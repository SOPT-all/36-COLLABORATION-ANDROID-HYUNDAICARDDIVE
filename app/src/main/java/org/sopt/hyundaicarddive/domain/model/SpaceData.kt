package org.sopt.hyundaicarddive.domain.model

data class SpaceData(
    val bannerUrl: String,
    val introduction: String,
    val address: String,
    val reviewList: List<SpaceReviewData>,
    val telephone: String,
    val email: String
)

data class SpaceReviewData(
    val imageUrl: String,
    val reviewer: String,
    val likeCount: Int,
)