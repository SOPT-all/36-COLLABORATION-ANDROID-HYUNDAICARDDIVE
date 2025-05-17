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
        R.string.spaceandculture_space_card_musiclib,
        R.drawable.img_space_logo_musiclib
    ),
    SPACE_COOKINGLIB(
        R.string.spaceandculture_space_card_cookinglib,
        R.drawable.img_space_logo_cookinglib
    ),
    SPACE_ARTLIB(
        R.string.spaceandculture_space_card_artlib,
        R.drawable.img_space_logo_artlib
    ),
    SPACE_UNDERSTAGE(
        R.string.spaceandculture_space_card_understage,
        R.drawable.img_space_logo_understage
    ),
    SPACE_VINYL(
        R.string.spaceandculture_space_card_vinyl,
        R.drawable.img_space_logo_vinyl
    ),
    SPACE_STORAGE(
        R.string.spaceandculture_space_card_storage,
        R.drawable.img_space_logo_storage
    ),
    SPACE_IRON(
        R.string.spaceandculture_space_card_iron,
        R.drawable.img_space_logo_iron
    ),
    SPACE_RED11(
        R.string.spaceandculture_space_card_red11,
        R.drawable.img_space_logo_red11
    ),
    SPACE_CARD(
        R.string.spaceandculture_space_card_card,
        R.drawable.img_space_logo_card
    ),
    CULTURE_SUPER(
        R.string.spaceandculture_culture_card_super,
        R.drawable.img_culture_logo_super
    ),
    CULTURE_CULTURE(
        R.string.spaceandculture_culture_card_culture,
        R.drawable.img_culture_logo_culture
    ),
    CULTURE_DAVINCI(
        R.string.spaceandculture_culture_card_davinci,
        R.drawable.img_culture_logo_davinci
    ),
    CULTURE_OVER(
        R.string.spaceandculture_culture_card_over,
        R.drawable.img_culture_logo_over
    ),
    CULTURE_FAN(
        R.string.spaceandculture_culture_card_fan,
        R.drawable.img_culture_logo_fan
    ),
    CULTURE_LIMITED(
        R.string.spaceandculture_culture_card_limited,
        R.drawable.img_culture_logo_limited
    )
}
