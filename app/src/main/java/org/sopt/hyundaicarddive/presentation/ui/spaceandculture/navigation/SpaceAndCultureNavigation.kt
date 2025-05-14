package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.hyundaicarddive.core.navigation.MainTabRoute
import org.sopt.hyundaicarddive.presentation.ui.detail.navigation.navigateToDetail
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.SpaceAndCultureRoute

fun NavController.navigateToSpaceAndCulture(navOptions: NavOptions) {
    navigate(MainTabRoute.SpaceAndCulture, navOptions)
}

fun NavGraphBuilder.spaceAndCultureNavGraph(
    padding: PaddingValues,
    navController: NavController
) {
    composable<MainTabRoute.SpaceAndCulture> {
        SpaceAndCultureRoute(
            padding = padding,
            navigateToDetail = { navController.navigateToDetail() }
        )
    }
}
