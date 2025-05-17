package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.util.noRippleClickable
import org.sopt.hyundaicarddive.presentation.type.SpaceAndCultureGridItem
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SpaceAndCultureCardGrid(
    modifier: Modifier = Modifier,
    cards: List<SpaceAndCultureGridItem>,
    navigateToDetail: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        cards.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                rowItems.forEach { card ->
                    SpaceAndCultureCard(
                        modifier = Modifier
                            .weight(1f),
                        description = card.description,
                        logoResId = card.logoResId,
                        onClick = navigateToDetail
                    )
                }
                repeat(3 - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun SpaceAndCultureCard(
    @StringRes description: Int,
    @DrawableRes logoResId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .aspectRatio(88f / 98f)
            .background(color = colors.white, shape = RoundedCornerShape(8.dp))
            .noRippleClickable(onClick)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(88f / 63f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(logoResId),
                    contentDescription = null
                )
            }

            Text(
                text = stringResource(description),
                color = colors.gray3,
                style = typography.ns_m_10,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpaceAndCultureCard() {
    HYUNDAICARDDIVETheme {
        SpaceAndCultureCard(
            description = R.string.spaceandculture_space_card_artlib,
            logoResId = R.drawable.img_space_logo_designlib
        )
    }
}
