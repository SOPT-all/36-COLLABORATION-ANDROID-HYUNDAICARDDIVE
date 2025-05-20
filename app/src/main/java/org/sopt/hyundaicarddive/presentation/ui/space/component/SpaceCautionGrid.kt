package org.sopt.hyundaicarddive.presentation.ui.space.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.presentation.type.SpaceCautionGridItem
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SpaceCautionGrid(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SpaceCautionGridItem.entries.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { card ->
                    SpaceCautionGridCard(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        spaceCautionGridItem = card
                    )
                }
            }
        }
    }
}

@Composable
private fun SpaceCautionGridCard(
    spaceCautionGridItem: SpaceCautionGridItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(spaceCautionGridItem.logoResId),
            contentDescription = null
        )

        Text(
            text = stringResource(spaceCautionGridItem.description),
            color = colors.gray5,
            style = typography.ns_r_14,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp)
        )
        spaceCautionGridItem.detailDescription?.let {
            Text(
                text = stringResource(spaceCautionGridItem.detailDescription),
                color = colors.gray4,
                style = typography.ns_r_12,
                textAlign = TextAlign.Center
            )
        }
    }
}
