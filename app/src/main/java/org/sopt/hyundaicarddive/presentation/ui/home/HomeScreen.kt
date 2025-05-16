package org.sopt.hyundaicarddive.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.component.TopBar
import org.sopt.hyundaicarddive.presentation.model.HomeListModel
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.presentation.ui.home.component.CategoryBar
import org.sopt.hyundaicarddive.presentation.ui.home.component.HomeCardListSection
import org.sopt.hyundaicarddive.presentation.ui.home.component.HomeSlideListSection
import org.sopt.hyundaicarddive.presentation.ui.home.component.SortOptionBar
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors

@Composable
fun HomeRoute(
    padding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getHomeList()
    }
    val selectedOption by viewModel.selectedOption.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val changeListAlign by viewModel.changeListAlign.collectAsStateWithLifecycle()
    val homeList by viewModel.homeList.collectAsStateWithLifecycle()

    HomeScreen(
        selectedOption = selectedOption,
        onOptionSelected = { viewModel.onOptionSelected(it) },
        selectedCategory = selectedCategory,
        onCategorySelected = { viewModel.onCategorySelected(it) },
        changeListAlign = changeListAlign,
        onChangeListAlign = { viewModel.onChangeListAlign() },
        homeList = homeList,
        modifier = Modifier.padding(padding)
    )
}

@Composable
private fun HomeScreen(
    selectedOption: Int,
    onOptionSelected: (Int) -> Unit,
    selectedCategory: Int,
    onCategorySelected: (Int) -> Unit,
    changeListAlign: Boolean,
    onChangeListAlign: () -> Unit,
    homeList: List<HomeListModel>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            TopBar(topBarType = TopBarType.HOME)

            SortOptionBar(
                selectedIndex = selectedOption,
                onIndexSelected = onOptionSelected
            )

            CategoryBar(
                selectedIndex = selectedCategory,
                onIndexSelected = onCategorySelected
            )

            if (changeListAlign) {
                HomeCardListSection(
                    items = homeList,
                    modifier = Modifier.padding(horizontal = 27.dp)
                )
            } else {
                HomeSlideListSection(
                    items = homeList,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }
        }

        FloatingActionButton(
            onClick = onChangeListAlign,
            shape = CircleShape,
            containerColor = colors.white,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 16.dp,
                    bottom = 18.dp
                )
        ) {
            Icon(
                imageVector = if (changeListAlign) ImageVector.vectorResource(R.drawable.ic_home_align_slide_40) else ImageVector.vectorResource(R.drawable.ic_home_align_card_40),
                contentDescription = null,
                tint = colors.black
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
            onCategorySelected = {},
            changeListAlign = false,
            homeList = listOf(
                HomeListModel(
                    category = "쿠킹-고메",
                    title = "집밥은 아쉬운\n그런 날 있잖아",
                    hashTag = "신상 맛집 #21",
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
                ),
                HomeListModel(
                    category = "여행",
                    title = "예술 세계 속으로",
                    hashTag = "디깅 투어#2\n대구-경주 건축 여행 #3",
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
                )
            ),
            onChangeListAlign = {}
        )
    }
}
