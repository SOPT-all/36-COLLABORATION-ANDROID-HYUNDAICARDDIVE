package org.sopt.hyundaicarddive.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpaceResponseDto(
    @SerialName("banner")
    val bannerUrl: String,
    @SerialName("introduction")
    val introduction: String,
    @SerialName("address")
    val address: String,
    @SerialName("reviewList")
    val reviewList: List<ReviewListDto>,
    @SerialName("telephone")
    val telephone: String,
    @SerialName("email")
    val email: String
)

@Serializable
data class ReviewListDto(
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("reviewer")
    val reviewer: String,
    @SerialName("likeCount")
    val likeCount: Int
)
