package org.sopt.hyundaicarddive.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.presentation.model.HomeListModel
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun HomeCardListSection(
    items: List<HomeListModel>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(0.dp)
    ) {
        items(items.size) { index ->
            HomeCardList(
                homeListModel = items[index],
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}

@Composable
private fun HomeCardList(
    homeListModel: HomeListModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = homeListModel.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(147f / 243f)
                .clip(RoundedCornerShape(7.dp)),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.background(
                    color = colors.white,
                    shape = RoundedCornerShape(200.dp)
                ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = homeListModel.category,
                    style = typography.ns_sb_9,
                    color = colors.black,
                    modifier = Modifier
                        .padding(
                            horizontal = 10.dp,
                            vertical = 2.dp
                        )
                )
            }

            Text(
                text = homeListModel.title,
                style = typography.ns_b_14,
                color = colors.white,
                modifier = Modifier.padding(vertical = 7.dp)
            )

            Text(
                text = homeListModel.hashTag,
                style = typography.ns_sb_9,
                color = colors.white
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeCardList() {
    HYUNDAICARDDIVETheme {
        HomeCardListSection(
            items = listOf(
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
            )
        )
    }
}
