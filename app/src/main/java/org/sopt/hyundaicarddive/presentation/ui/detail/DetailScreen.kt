package org.sopt.hyundaicarddive.presentation.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun DetailRoute(
    padding: PaddingValues,
    navigateToSpace: () -> Unit
) {
    DetailScreen(
        padding = padding,
        navigateToSpace = navigateToSpace
    )
}

@Composable
private fun DetailScreen(
    padding: PaddingValues,
    navigateToSpace: () -> Unit
) {
    Text(
        text = "DetailScreen",
        modifier = Modifier.clickable { navigateToSpace() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    HYUNDAICARDDIVETheme {
        DetailScreen(
            padding = PaddingValues(),
            navigateToSpace = {}
        )
    }
}