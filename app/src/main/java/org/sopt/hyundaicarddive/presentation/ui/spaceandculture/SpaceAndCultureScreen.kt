package org.sopt.hyundaicarddive.presentation.ui.spaceandculture

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceAndCultureRoute(
    padding: PaddingValues,
    navigateToDetail: () -> Unit
) {
    SpaceAndCultureScreen(
        padding = padding,
        navigateToDetail = navigateToDetail
    )
}

@Composable
private fun SpaceAndCultureScreen(
    padding: PaddingValues,
    navigateToDetail: () -> Unit
) {
    Text(
        text = "SpaceAndCultureScreen",
        modifier = Modifier.clickable { navigateToDetail() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpaceAndCultureScreen() {
    HYUNDAICARDDIVETheme {
        SpaceAndCultureScreen(
            padding = PaddingValues(),
            navigateToDetail = {}
        )
    }
}
