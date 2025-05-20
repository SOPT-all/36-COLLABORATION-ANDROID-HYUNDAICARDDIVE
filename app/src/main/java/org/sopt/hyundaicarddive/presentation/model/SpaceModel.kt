package org.sopt.hyundaicarddive.presentation.model

data class SpaceModel(
    val bannerUrl: String,
    val introduction: String,
    val address: String,
    val telephone: String,
    val email: String,
)

data class SpaceReviewModel(
    val imgUrl: String,
    val reviewer: String,
    val likeCount: Int,
    val isLiked: Boolean = false
)