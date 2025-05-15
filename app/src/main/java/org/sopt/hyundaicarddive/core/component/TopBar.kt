package org.sopt.hyundaicarddive.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.core.util.noRippleClickable
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun TopBar(
    topBarType: TopBarType,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(vertical = 18.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (topBarType.centerIcon != null) Arrangement.Center else Arrangement.Start
    ) {
        when (topBarType) {
            TopBarType.DETAIL -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = topBarType.backIcon!!),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .noRippleClickable(onClick = onBackClick)
                )
            }

            else -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = topBarType.centerIcon!!),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopBar1() {
    HYUNDAICARDDIVETheme {
        TopBar(
            topBarType = TopBarType.HOME
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopBar2() {
    HYUNDAICARDDIVETheme {
        TopBar(
            topBarType = TopBarType.SPACEANDCULTURE
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopBar3() {
    HYUNDAICARDDIVETheme {
        TopBar(
            topBarType = TopBarType.DETAIL
        )
    }
}