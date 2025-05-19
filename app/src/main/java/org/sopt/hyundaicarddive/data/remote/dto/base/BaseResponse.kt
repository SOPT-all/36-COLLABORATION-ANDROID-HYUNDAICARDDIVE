package org.sopt.hyundaicarddive.data.remote.dto.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val data: T?,
    @SerialName("message")
    val message: String?
)
