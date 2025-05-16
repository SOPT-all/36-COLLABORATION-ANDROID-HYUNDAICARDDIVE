package org.sopt.hyundaicarddive.presentation.model

data class DetailModel(
    val address: String,
    val operationTime: String,
    val articleList: List<DetailArticleModel>
)

data class DetailArticleModel(
    val imageUrl: String,
    val title: String,
    val subTitle: String,
    val date: String
)