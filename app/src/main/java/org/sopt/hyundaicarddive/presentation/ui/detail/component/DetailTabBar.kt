package org.sopt.hyundaicarddive.presentation.ui.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.presentation.type.DetailMenuItem
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun DetailTabBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DetailMenuItem.entries.forEach { menu ->
            DetailTabBarItem(menu)
        }
    }
}

@Composable
private fun DetailTabBarItem(
    item: DetailMenuItem
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = item.iconRes),
            contentDescription = stringResource(id = item.stringRes),
            modifier = Modifier
                .padding(bottom = 11.dp)
        )

        Text(
            text = stringResource(id = item.stringRes),
            color = HYUNDAICARDDIVETheme.colors.black,
            style = HYUNDAICARDDIVETheme.typography.ns_m_10
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailTabBar() {
    DetailTabBar()
}
