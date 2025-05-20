package org.sopt.hyundaicarddive.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponseDto(
    @SerialName("cardList")
    val cardList: List<CardListDto>
)

@Serializable
data class CardListDto(
    @SerialName("title")
    val title: String,
    @SerialName("category")
    val category: String,
    @SerialName("hashTag")
    val hashTag: String,
    @SerialName("imageUrl")
    val imageUrl: String
)
