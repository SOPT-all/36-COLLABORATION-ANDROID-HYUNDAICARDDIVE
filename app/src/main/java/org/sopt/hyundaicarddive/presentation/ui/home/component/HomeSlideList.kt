package org.sopt.hyundaicarddive.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.util.noRippleClickable
import org.sopt.hyundaicarddive.presentation.model.HomeListModel
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun HomeSlideListSection(
    items: List<HomeListModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(0.dp)
    ) {
        items(items.size) { index ->
            HomeSlideList(
                homeListModel = items[index],
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
private fun HomeSlideList(
    homeListModel: HomeListModel,
    modifier: Modifier = Modifier
) {
    var isBookMarked by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = homeListModel.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(300f / 416f)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )

        Icon(
            imageVector = if (isBookMarked) ImageVector.vectorResource(R.drawable.ic_home_bookmark_fill_white_40) else ImageVector.vectorResource(R.drawable.ic_home_bookmark_white_40),
            contentDescription = null,
            tint = colors.white,
            modifier = Modifier
                .padding(top = 21.dp, end = 12.dp)
                .align(Alignment.TopEnd)
                .noRippleClickable {
                    isBookMarked = !isBookMarked
                }
        )

        Column(
            modifier = Modifier
                .padding(start = 21.dp, bottom = 22.dp)
                .align(Alignment.BottomStart)
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
                    style = typography.ns_sb_12,
                    color = colors.black,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 4.dp
                        )
                )
            }

            Text(
                text = homeListModel.title,
                style = typography.ns_b_32,
                color = colors.white,
                modifier = Modifier.padding(vertical = 7.dp)
            )

            Text(
                text = homeListModel.hashTag,
                style = typography.ns_sb_16,
                color = colors.white
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeSlideList() {
    HYUNDAICARDDIVETheme {
        HomeSlideListSection(
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
