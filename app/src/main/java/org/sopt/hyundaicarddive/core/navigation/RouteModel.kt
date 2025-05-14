package org.sopt.hyundaicarddive.core.navigation

import kotlinx.serialization.Serializable

sealed interface MainTabRoute {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object SpaceAndCulture : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}

sealed interface SpaceAndCultureRoute {
    @Serializable
    data object Detail : SpaceAndCultureRoute

    @Serializable
    data object Space : SpaceAndCultureRoute
}
