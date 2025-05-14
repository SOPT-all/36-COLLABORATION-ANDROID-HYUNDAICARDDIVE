package org.sopt.hyundaicarddive.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.sopt.hyundaicarddive.R

enum class DetailMenuItem(
    @DrawableRes val iconRes: Int,
    @StringRes val stringRes: Int
) {
    SPACE(
        iconRes = R.drawable.ic_spacedetail_space_28,
        stringRes = R.string.detail_menu_space_title
    ),
    BOOKSEARCH(
        iconRes = R.drawable.ic_spacedetail_booksearch_28,
        stringRes = R.string.detail_menu_book_search_title
    ),
    RESERVATION(
        iconRes = R.drawable.ic_spacedetail_reservation_28,
        stringRes = R.string.detail_menu_reservation_title
    ),
    REVIEW(
        iconRes = R.drawable.ic_spacedetail_review_28,
        stringRes = R.string.detail_menu_review_title
    ),
    BOOK(
        iconRes = R.drawable.ic_spacedetail_book_28,
        stringRes = R.string.detail_menu_book_title
    )
}