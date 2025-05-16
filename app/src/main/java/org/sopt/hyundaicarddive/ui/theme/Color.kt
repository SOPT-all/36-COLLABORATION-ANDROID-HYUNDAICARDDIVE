package org.sopt.hyundaicarddive.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Black
val Black = Color(0xFF000000) // 100%
val Black10 = Black.copy(alpha = 0.1f)// 10%
val Black30 = Black.copy(alpha = 0.3f) // 30%
val Black50 = Black.copy(alpha = 0.5f) // 50%

// White
val White = Color(0xFFFFFFFF)
val White2 = Color(0xFFF5F5F5)
val White40 = White.copy(alpha = 0.4f) // 40%

// Gray scale
val Gray1 = Color(0xFFEEEEEE)
val Gray2 = Color(0xFFC2C2C4)
val Gray3 = Color(0xFFBBBBBB)
val Gray4 = Color(0xFF858585)
val Gray5 = Color(0xFF444444)

// Android
val AndSysGray = Color(0xFF858585)
val AndSysWhite = Color(0xFFF6F6F8)

// Point
val PointRed = Color(0xFFF84A49)
val PointYellow = Color(0xFFF8E000)
val PointGreen = Color(0xFF018C15)

@Immutable
data class HyunDaiCardDiveColors(
    val black: Color,
    val black10: Color,
    val black30: Color,
    val black50: Color,
    val white: Color,
    val white2: Color,
    val white40: Color,
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val andSysGray: Color,
    val andSysWhite: Color,
    val pointRed: Color,
    val pointYellow: Color,
    val pointGreen: Color
)

val defaultHyunDaiCardDiveColors = HyunDaiCardDiveColors(
    black = Black,
    black10 = Black10,
    black30 = Black30,
    black50 = Black50,
    white = White,
    white2 = White2,
    white40 = White40,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    gray5 = Gray5,
    andSysGray = AndSysGray,
    andSysWhite = AndSysWhite,
    pointRed = PointRed,
    pointYellow = PointYellow,
    pointGreen = PointGreen
)

val LocalHyunDaiCardDiveColorsProvider = staticCompositionLocalOf { defaultHyunDaiCardDiveColors }
