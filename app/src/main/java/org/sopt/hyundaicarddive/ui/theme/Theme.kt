package org.sopt.hyundaicarddive.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object HyunDaiCardDiveTheme {
    val colors: HyunDaiCardDiveColors
        @Composable
        @ReadOnlyComposable
        get() = LocalHyunDaiCardDiveColorsProvider.current

    val typography: HyunDaiCardDiveTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalHyunDaiCardDiveTypographyProvider.current
}

@Composable
fun ProvideHyunDaiCardDiveColorsAndTypography(
    colors: HyunDaiCardDiveColors,
    typography: HyunDaiCardDiveTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalHyunDaiCardDiveColorsProvider provides colors,
        LocalHyunDaiCardDiveTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun HyunDaiCardDiveTheme(
    content: @Composable () -> Unit
) {
    ProvideHyunDaiCardDiveColorsAndTypography(
        colors = defaultHyunDaiCardDiveColors,
        typography = defaultHyunDaiCardDiveTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}