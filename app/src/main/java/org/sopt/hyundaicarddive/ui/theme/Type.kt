package org.sopt.hyundaicarddive.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.sopt.hyundaicarddive.R

val hyunDaiCardDiveFont = FontFamily(Font(R.font.youandimodern))
val hyunDaiCardDiveFontBold = FontFamily(Font(R.font.notosanskr_bold))
val hyunDaiCardDiveFontSemiBold = FontFamily(Font(R.font.notosanskr_semibold))
val hyunDaiCardDiveFontExtraBold = FontFamily(Font(R.font.notosanskr_semibold))
val hyunDaiCardDiveFontMedium = FontFamily(Font(R.font.notosanskr_medium))
val hyunDaiCardDiveFontRegular = FontFamily(Font(R.font.notosanskr_regular))

@Immutable
data class HyunDaiCardDiveTypography(
    val uni_20: TextStyle,
    val uni_16: TextStyle,
    val ns_b_32: TextStyle,
    val ns_eb_22: TextStyle,
    val ns_sb_20: TextStyle,
    val ns_b_16: TextStyle,
    val ns_sb_16: TextStyle,
    val ns_r_16: TextStyle,
    val ns_b_14: TextStyle,
    val ns_sb_14: TextStyle,
    val ns_r_14: TextStyle,
    val ns_m_13: TextStyle,
    val ns_sb_12: TextStyle,
    val ns_m_12_22: TextStyle,
    val ns_m_12_18: TextStyle,
    val ns_r_12: TextStyle,
    val ns_m_11: TextStyle,
    val ns_r_11: TextStyle,
    val ns_m_10: TextStyle,
    val ns_r_10: TextStyle,
    val ns_sb_9: TextStyle
)

val defaultHyunDaiCardDiveTypography = HyunDaiCardDiveTypography(
    uni_20 = TextStyle(
        fontFamily = hyunDaiCardDiveFont,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.3).sp
    ),
    uni_16 = TextStyle(
        fontFamily = hyunDaiCardDiveFont,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_b_32 = TextStyle(
        fontFamily = hyunDaiCardDiveFontBold,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.sp
    ),
    ns_eb_22 = TextStyle(
        fontFamily = hyunDaiCardDiveFontExtraBold,
        fontSize = 22.sp,
        lineHeight = 33.sp,
        letterSpacing = 0.sp
    ),
    ns_sb_20 = TextStyle(
        fontFamily = hyunDaiCardDiveFontSemiBold,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_b_16 = TextStyle(
        fontFamily = hyunDaiCardDiveFontBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    ns_sb_16 = TextStyle(
        fontFamily = hyunDaiCardDiveFontSemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.2).sp
    ),
    ns_r_16 = TextStyle(
        fontFamily = hyunDaiCardDiveFontRegular,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    ns_b_14 = TextStyle(
        fontFamily = hyunDaiCardDiveFontBold,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_sb_14 = TextStyle(
        fontFamily = hyunDaiCardDiveFontSemiBold,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_r_14 = TextStyle(
        fontFamily = hyunDaiCardDiveFontRegular,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    ),
    ns_m_13 = TextStyle(
        fontFamily = hyunDaiCardDiveFontMedium,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    ns_sb_12 = TextStyle(
        fontFamily = hyunDaiCardDiveFontSemiBold,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.6).sp
    ),
    ns_m_12_22 = TextStyle(
        fontFamily = hyunDaiCardDiveFontMedium,
        fontSize = 12.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_m_12_18 = TextStyle(
        fontFamily = hyunDaiCardDiveFontMedium,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.1).sp
    ),
    ns_r_12 = TextStyle(
        fontFamily = hyunDaiCardDiveFontRegular,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.1).sp
    ),
    ns_m_11 = TextStyle(
        fontFamily = hyunDaiCardDiveFontMedium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_r_11 = TextStyle(
        fontFamily = hyunDaiCardDiveFontRegular,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    ns_m_10 = TextStyle(
        fontFamily = hyunDaiCardDiveFontMedium,
        fontSize = 10.sp,
        lineHeight = 15.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_r_10 = TextStyle(
        fontFamily = hyunDaiCardDiveFontRegular,
        fontSize = 10.sp,
        lineHeight = 15.sp,
        letterSpacing = (-0.3).sp
    ),
    ns_sb_9 = TextStyle(
        fontFamily = hyunDaiCardDiveFontSemiBold,
        fontSize = 9.sp,
        lineHeight = 13.sp,
        letterSpacing = 0.sp
    )
)

val LocalHyunDaiCardDiveTypographyProvider = staticCompositionLocalOf { defaultHyunDaiCardDiveTypography }