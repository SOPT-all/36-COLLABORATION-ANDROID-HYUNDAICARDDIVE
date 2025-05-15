package org.sopt.hyundaicarddive.presentation.type

import androidx.annotation.DrawableRes
import org.sopt.hyundaicarddive.R

enum class TopBarType(
    @DrawableRes val centerIcon: Int? = null,
    @DrawableRes val backIcon: Int? = null
) {
    HOME(
        centerIcon = R.drawable.ic_home_logo_article
    ),
    SPACEANDCULTURE(
        centerIcon = R.drawable.ic_spaceculture_logo_space_culture
    ),
    DETAIL(
        backIcon = R.drawable.ic_introduce_back_10
    )
}
