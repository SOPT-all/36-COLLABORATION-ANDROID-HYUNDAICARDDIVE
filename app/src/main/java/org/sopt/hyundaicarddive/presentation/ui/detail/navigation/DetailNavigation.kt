package org.sopt.hyundaicarddive.presentation.ui.detail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.hyundaicarddive.core.navigation.SpaceAndCultureRoute
import org.sopt.hyundaicarddive.presentation.ui.detail.DetailRoute
import org.sopt.hyundaicarddive.presentation.ui.space.navigation.navigateToSpace

fun NavController.navigateToDetail() {
    navigate(SpaceAndCultureRoute.Detail)
}

fun NavGraphBuilder.detailNavGraph(
    padding: PaddingValues,
    navController: NavController
) {
    composable<SpaceAndCultureRoute.Detail> {
        DetailRoute(
            padding = padding,
            navigateToSpace = { navController.navigateToSpace() }
        )
    }
}
