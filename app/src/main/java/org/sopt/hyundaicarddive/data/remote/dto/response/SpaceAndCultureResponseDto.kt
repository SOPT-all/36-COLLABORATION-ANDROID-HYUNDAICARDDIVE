package org.sopt.hyundaicarddive.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpaceAndCultureResponseDto (
    @SerialName("dataList")
    val dataList: List<WhatsOnListDto>
)

@Serializable
data class WhatsOnListDto(
    @SerialName("date")
    val date: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("stage")
    val stage: String,
    @SerialName("location")
    val location: String,
    @SerialName("reservation")
    val isReservable: Boolean,
    @SerialName("image")
    val imageUrl: String,
)