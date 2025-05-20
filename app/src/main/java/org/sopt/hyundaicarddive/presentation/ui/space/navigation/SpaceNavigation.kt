package org.sopt.hyundaicarddive.presentation.ui.space.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.hyundaicarddive.core.navigation.SpaceAndCultureRoute
import org.sopt.hyundaicarddive.presentation.ui.space.SpaceRoute

fun NavController.navigateToSpace() {
    navigate(SpaceAndCultureRoute.Space)
}

fun NavGraphBuilder.spaceNavGraph(
    padding: PaddingValues,
    navController: NavController
) {
    composable<SpaceAndCultureRoute.Space> {
        SpaceRoute(
            padding = padding,
            onBackClick = { navController.popBackStack() }
        )
    }
}
