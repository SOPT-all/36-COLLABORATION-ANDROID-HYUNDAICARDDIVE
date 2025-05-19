package org.sopt.hyundaicarddive.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.hyundaicarddive.R

enum class SpaceCautionGridItem(
    @StringRes val description: Int,
    @DrawableRes val logoResId: Int,
    @StringRes val detailDescription: Int? = null,
) {
    CAUTION1(
        description = R.string.space_notice_description1,
        logoResId = R.drawable.ic_introduce_caution1_32,
    ),
    CAUTION2(
        description = R.string.space_notice_description2,
        logoResId = R.drawable.ic_introduce_caution2_32,
    ),
    CAUTION3(
        description = R.string.space_notice_description3,
        logoResId = R.drawable.ic_introduce_caution3_32,
    ),
    CAUTION4(
        description = R.string.space_notice_description4,
        logoResId = R.drawable.ic_introduce_caution4_32,
    ),
    CAUTION5(
        description = R.string.space_notice_description5,
        logoResId = R.drawable.ic_introduce_caution5_32,
    ),
    CAUTION6(
        description = R.string.space_notice_description6,
        logoResId = R.drawable.ic_introduce_caution6_32,
        detailDescription = R.string.space_notice_description6_detail,
    ),
}