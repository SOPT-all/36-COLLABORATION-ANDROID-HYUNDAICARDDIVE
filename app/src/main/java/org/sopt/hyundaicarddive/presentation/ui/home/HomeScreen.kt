package org.sopt.hyundaicarddive.presentation.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun HomeRoute(
    padding: PaddingValues
) {
    HomeScreen(padding = padding)
}

@Composable
private fun HomeScreen(
    padding: PaddingValues
) {
    Text("HomeScreen")
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HYUNDAICARDDIVETheme {
        HomeScreen(padding = PaddingValues())
    }
}
