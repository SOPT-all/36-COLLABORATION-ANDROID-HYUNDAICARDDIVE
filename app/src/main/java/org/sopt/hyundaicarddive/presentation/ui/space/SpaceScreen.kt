package org.sopt.hyundaicarddive.presentation.ui.space

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceRoute(
    padding: PaddingValues
) {
    SpaceScreen(padding = padding)
}

@Composable
private fun SpaceScreen(
    padding: PaddingValues
) {
    Text("SpaceScreen")
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HYUNDAICARDDIVETheme {
        SpaceScreen(padding = PaddingValues())
    }
}
