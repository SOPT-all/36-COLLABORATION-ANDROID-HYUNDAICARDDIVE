package org.sopt.hyundaicarddive.data.mapper.todomain

import org.sopt.hyundaicarddive.data.remote.dto.response.ArticleListDto
import org.sopt.hyundaicarddive.data.remote.dto.response.DetailResponseDto
import org.sopt.hyundaicarddive.domain.model.DetailArticleData
import org.sopt.hyundaicarddive.domain.model.DetailData

fun DetailResponseDto.toDomain(): DetailData = DetailData(
    address = this.address,
    operationTime = this.operationTime,
    articleList = this.articleList.map {
        it.toDomain()
    }
)

fun ArticleListDto.toDomain(): DetailArticleData = DetailArticleData(
    imageUrl = this.imageUrl,
    title = this.title,
    subTitle = this.subTitle,
    date = this.date
)
