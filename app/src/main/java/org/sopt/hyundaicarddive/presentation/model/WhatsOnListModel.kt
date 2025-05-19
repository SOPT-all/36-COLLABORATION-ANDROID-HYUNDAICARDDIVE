package org.sopt.hyundaicarddive.presentation.model

data class WhatsOnListModel(
    val date: String,
    val title: String,
    val description: String,
    val stage: String,
    val location: String,
    val isReservable: Boolean,
    val imageUrl: String
)
