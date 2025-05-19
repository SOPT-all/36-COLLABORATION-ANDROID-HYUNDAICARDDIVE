package org.sopt.hyundaicarddive.presentation.model

data class SpaceReviewModel(
    val imgUrl: String,
    val reviewer: String,
    val likeCount: Int,
    val isLiked: Boolean = false
)
