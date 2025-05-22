package org.sopt.hyundaicarddive.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailResponseDto(
    @SerialName("address")
    val address: String,
    @SerialName("operationTime")
    val operationTime: String,
    @SerialName("articleList")
    val articleList: List<ArticleListDto>
)

@Serializable
data class ArticleListDto(
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("subTitle")
    val subTitle: String,
    @SerialName("date")
    val date: String
)
