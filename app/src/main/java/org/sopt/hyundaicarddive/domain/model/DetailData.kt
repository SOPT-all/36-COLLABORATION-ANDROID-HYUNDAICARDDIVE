package org.sopt.hyundaicarddive.domain.model

data class DetailData(
    val address: String,
    val operationTime: String,
    val articleList: List<DetailArticleData>
)

data class DetailArticleData(
    val imageUrl: String,
    val title: String,
    val subTitle: String,
    val date: String
)
