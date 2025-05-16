package org.sopt.hyundaicarddive.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.hyundaicarddive.R

data class SpaceAndCultureCardInfo(
    @StringRes val description: Int,
    @DrawableRes val iconResId: Int,
)

object SpaceAndCultureCardDataProvider {
    val spaceCards = listOf(
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description1,
            R.drawable.ic_space_logo_designlib
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description2,
            R.drawable.ic_space_logo_musiclib
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description3,
            R.drawable.ic_space_logo_cookinglib
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description4,
            R.drawable.ic_space_logo_artlib
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description5,
            R.drawable.ic_space_logo_understage
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description6,
            R.drawable.ic_space_logo_vinyl
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description7,
            R.drawable.ic_space_logo_storage
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description8,
            R.drawable.ic_space_logo_iron
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description9,
            R.drawable.ic_space_logo_red11
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_space_card_description10,
            R.drawable.ic_space_logo_card
        ),
    )

    val cultureCards = listOf(
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_culture_card_description1,
            R.drawable.ic_culture_logo_super
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_culture_card_description2,
            R.drawable.ic_culture_logo_culture
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_culture_card_description3,
            R.drawable.ic_culture_logo_davinci
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_culture_card_description4,
            R.drawable.ic_culture_logo_over
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_culture_card_description5,
            R.drawable.ic_culture_logo_fan
        ),
        SpaceAndCultureCardInfo(
            R.string.spaceandculture_culture_card_description6,
            R.drawable.ic_culture_logo_limited
        ),
    )

}