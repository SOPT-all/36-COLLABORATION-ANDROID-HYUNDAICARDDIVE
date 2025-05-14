package org.sopt.hyundaicarddive.presentation.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.navigation.MainTabRoute

enum class MainTab(
    @DrawableRes val defaultIconResId: Int,
    @DrawableRes val selectedIconResId: Int,
    val route: MainTabRoute
){
    HOME(
        defaultIconResId = R.drawable.ic_navi_home_gray_36,
        selectedIconResId = R.drawable.ic_navi_home_fill_black_36,
        route = MainTabRoute.Home
    ),
    SPACEANDCULTURE(
        defaultIconResId = R.drawable.ic_navi_culture_gray_36,
        selectedIconResId = R.drawable.ic_navi_culture_fill_black_36,
        route = MainTabRoute.SpaceAndCulture
    ),
    MY(
        defaultIconResId = R.drawable.ic_navi_profile_gray_36,
        selectedIconResId = R.drawable.ic_navi_profile_gray_36,
        route = MainTabRoute.My
    );

    companion object {
        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean {
            return MainTab.entries.map { it.route }.any { predicate(it) }
        }
    }
}