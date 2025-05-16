package org.sopt.hyundaicarddive.presentation.ui.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.hyundaicarddive.core.navigation.MainTabRoute
import org.sopt.hyundaicarddive.presentation.ui.home.HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph() {
    composable<MainTabRoute.Home> {
        HomeRoute()
    }
}
