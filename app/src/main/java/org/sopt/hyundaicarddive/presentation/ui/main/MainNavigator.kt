package org.sopt.hyundaicarddive.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.hyundaicarddive.core.navigation.MainTabRoute
import org.sopt.hyundaicarddive.presentation.ui.home.navigation.navigateToHome
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.navigation.navigateToSpaceAndCulture

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTabRoute.Home

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            when (tab.route) {
                else -> currentDestination?.route == tab.route::class.qualifiedName
            }
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTab.HOME.route) {
                inclusive = false
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions)
            MainTab.SPACEANDCULTURE -> navController.navigateToSpaceAndCulture(navOptions)
            MainTab.MY -> navController.navigateToHome(navOptions)
        }
    }

    fun navigateToHome(navOptions: NavOptions? = null) {
        navController.navigateToHome(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        currentDestination?.route == it::class.qualifiedName
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}