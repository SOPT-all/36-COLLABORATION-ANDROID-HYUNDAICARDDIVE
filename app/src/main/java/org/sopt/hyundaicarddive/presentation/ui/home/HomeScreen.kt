package org.sopt.hyundaicarddive.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.hyundaicarddive.core.component.TopBar
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.presentation.ui.home.component.CategoryBar
import org.sopt.hyundaicarddive.presentation.ui.home.component.SortOptionBar
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val selectedOption by viewModel.selectedOption.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()

    HomeScreen(
        selectedOption = selectedOption,
        onOptionSelected = { viewModel.onOptionSelected(it) },
        selectedCategory = selectedCategory,
        onCategorySelected = { viewModel.onCategorySelected(it) }
    )
}

@Composable
private fun HomeScreen(
    selectedOption: Int,
    onOptionSelected: (Int) -> Unit,
    selectedCategory: Int,
    onCategorySelected: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                topBarType = TopBarType.HOME
            )
        },
        containerColor = colors.white,
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            SortOptionBar(
                selectedIndex = selectedOption,
                onIndexSelected = onOptionSelected
            )

            CategoryBar(
                selectedIndex = selectedCategory,
                onIndexSelected = onCategorySelected
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HYUNDAICARDDIVETheme {
        HomeScreen(
            selectedOption = 0,
            onOptionSelected = {},
            selectedCategory = 0,
            onCategorySelected = {}
        )
    }
}
