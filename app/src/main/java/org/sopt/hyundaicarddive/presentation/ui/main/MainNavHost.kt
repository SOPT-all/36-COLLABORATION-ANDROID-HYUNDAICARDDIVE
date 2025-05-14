package org.sopt.hyundaicarddive.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.hyundaicarddive.presentation.ui.detail.navigation.detailNavGraph
import org.sopt.hyundaicarddive.presentation.ui.home.navigation.homeNavGraph
import org.sopt.hyundaicarddive.presentation.ui.space.navigation.spaceNavGraph
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.navigation.spaceAndCultureNavGraph
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colors.white)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            homeNavGraph(padding)
            spaceAndCultureNavGraph(
                padding = padding,
                navController = navigator.navController
            )
            detailNavGraph(
                padding = padding,
                navController = navigator.navController
            )
            spaceNavGraph(padding)
        }
    }
}