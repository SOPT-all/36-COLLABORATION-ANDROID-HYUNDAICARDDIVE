package org.sopt.hyundaicarddive.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.hyundaicarddive.R

enum class SpaceAndCultureGridItem(
    @StringRes val description: Int,
    @DrawableRes val logoResId: Int
) {
    SPACE_DESIGNLIB(
        description = R.string.spaceandculture_space_card_designlib,
        logoResId = R.drawable.img_space_logo_designlib
    ),
    SPACE_MUSICLIB(
        description = R.string.spaceandculture_space_card_musiclib,
        logoResId = R.drawable.img_space_logo_musiclib
    ),
    SPACE_COOKINGLIB(
        description = R.string.spaceandculture_space_card_cookinglib,
        logoResId = R.drawable.img_space_logo_cookinglib
    ),
    SPACE_ARTLIB(
        description = R.string.spaceandculture_space_card_artlib,
        logoResId = R.drawable.img_space_logo_artlib
    ),
    SPACE_UNDERSTAGE(
        description = R.string.spaceandculture_space_card_understage,
        logoResId = R.drawable.img_space_logo_understage
    ),
    SPACE_VINYL(
        description = R.string.spaceandculture_space_card_vinyl,
        logoResId = R.drawable.img_space_logo_vinyl
    ),
    SPACE_STORAGE(
        description = R.string.spaceandculture_space_card_storage,
        logoResId = R.drawable.img_space_logo_storage
    ),
    SPACE_IRON(
        description = R.string.spaceandculture_space_card_iron,
        logoResId = R.drawable.img_space_logo_iron
    ),
    SPACE_RED11(
        description = R.string.spaceandculture_space_card_red11,
        logoResId = R.drawable.img_space_logo_red11
    ),
    SPACE_CARD(
        description = R.string.spaceandculture_space_card_card,
        logoResId = R.drawable.img_space_logo_card
    ),
    CULTURE_SUPER(
        description = R.string.spaceandculture_culture_card_super,
        logoResId = R.drawable.img_culture_logo_super
    ),
    CULTURE_CULTURE(
        description = R.string.spaceandculture_culture_card_culture,
        logoResId = R.drawable.img_culture_logo_culture
    ),
    CULTURE_DAVINCI(
        description = R.string.spaceandculture_culture_card_davinci,
        logoResId = R.drawable.img_culture_logo_davinci
    ),
    CULTURE_OVER(
        description = R.string.spaceandculture_culture_card_over,
        logoResId = R.drawable.img_culture_logo_over
    ),
    CULTURE_FAN(
        description = R.string.spaceandculture_culture_card_fan,
        logoResId = R.drawable.img_culture_logo_fan
    ),
    CULTURE_LIMITED(
        description = R.string.spaceandculture_culture_card_limited,
        logoResId = R.drawable.img_culture_logo_limited
    )
}
