package org.sopt.hyundaicarddive.domain.model

data class SpaceAndCultureWhatsOnData(
    val date: String,
    val title: String,
    val description: String,
    val stage: String,
    val location: String,
    val isReservable: Boolean,
    val imageUrl: String
)
