package org.sopt.hyundaicarddive.presentation.ui.space

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.presentation.model.SpaceReviewModel
import org.sopt.hyundaicarddive.presentation.ui.space.component.SpaceBaseButton
import org.sopt.hyundaicarddive.presentation.ui.space.component.SpaceReviewPager
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SpaceRoute(
    padding: PaddingValues,
    viewModel: SpaceViewModel = hiltViewModel()
) {
    val reviewList by viewModel.reviewList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getReviewListItem()
    }

    val pagerState = rememberPagerState(pageCount = {
        reviewList.size + 1
    })

    SpaceScreen(
        padding = padding,
        onBackClick = {},
        reviewList = reviewList,
        onClickLike = viewModel::toggleLike,
        pagerState = pagerState
    )
}

@Composable
private fun SpaceScreen(
    padding: PaddingValues,
    onBackClick: () -> Unit,
    onClickLike: (Int) -> Unit,
    pagerState: PagerState,
    reviewList: List<SpaceReviewModel>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            item {
                SpaceHeaderBannerSection()

                SpaceIntroductionSection()

                SpaceLocationSection()

                SpaceCrowdInfoSection()

                SpaceReviewSection(
                    reviewList = reviewList,
                    onClickLike = onClickLike,
                    pagerState = pagerState
                )

                SpaceContactSection()

                SpaceNoticeSection()
            }
        }

        Box(
            modifier = Modifier.padding(top = 6.dp, start = 16.dp)
        ) {
            FloatingActionButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.TopStart),
                shape = CircleShape,
                containerColor = colors.white
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_introduce_chevron_left_28),
                    contentDescription = null,
                    tint = colors.black
                )
            }
        }
    }
}

@Composable
private fun SpaceNoticeSection() {
}

@Composable
private fun SpaceContactSection() {

}

@Composable
private fun SpaceReviewSection(
    reviewList: List<SpaceReviewModel>,
    onClickLike: (Int) -> Unit,
    pagerState: PagerState
) {
    Text(
        text = "방문 인증",
        style = typography.ns_sb_20,
        color = colors.black,
        modifier = Modifier.padding(start = 20.dp, top = 24.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 20.dp)
            .background(color = colors.white2, shape = RoundedCornerShape(3.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 13.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_introduce_review_24),
                contentDescription = null
            )
            Text(
                text = "방문 경험을 공유해주세요.",
                style = typography.ns_r_14,
                color = colors.black,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_introduce_chevron_right_7),
                contentDescription = null
            )
        }
    }
    SpaceReviewPager(
        spaceReviewList = reviewList,
        onClickLike = onClickLike,
        pagerState = pagerState
    )
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )

}

@Composable
private fun SpaceCrowdInfoSection() {
    Box(
        modifier = Modifier.padding(vertical = 24.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "혼잡 시간대",
            style = typography.ns_sb_20,
            color = colors.black
        )
        Image(
            painter = painterResource(id = R.drawable.img_introduce_congestion_graph),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(320f / 214f)
                .padding(top = 10.dp)
        )
    }
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )
}

@Composable
private fun SpaceLocationSection() {
    Text(
        text = "오시는 길",
        style = typography.ns_sb_20,
        color = colors.black,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 24.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "서울시 종로구 북촌로 31-18",
            style = typography.ns_r_14,
            color = colors.gray5,
            modifier = Modifier.padding(vertical = 1.5.dp)
        )
        Image(
            painter = painterResource(R.drawable.img_introduce_btn_map),
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .aspectRatio(66f / 24f)
        )
    }
    Image(
        painter = painterResource(id = R.drawable.img_introduce_map),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(360f / 190f)
    )
    SpaceBaseButton(
        text = "카카오맵으로 열기",
        paddingValues = PaddingValues(top = 16.dp, bottom = 24.dp, start = 20.dp, end = 20.dp)
    )
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )
}

@Composable
private fun SpaceIntroductionSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            text = "공간소개",
            style = typography.ns_sb_20,
            color = colors.black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "현대카드 디자인 라이브러리는 근대 디자인 정신이\n태동한 지점인 바우하우스 이후의 디자인," + " 건축, 현대\n미술에 관한 1만 9천여 권의 전문서적을 엄선하여 선\n보인다. 소량 인쇄했거나," + " 절판된 희귀 도서를 포함해\n글로벌 북 큐레이터가 선정한 북 컬렉션과 디자인에\n특화된 도서 카테고리에서 디자인 라이브러리의 전\n문성과 객관성을 발견할 수 있다.\n\n가회동에서 위치한 전통과 현대의 조화로 재해석해\n리노베이션 한 라이브러리 공간에서는 다채로운 경\n험을 선사한다." + " \n\n바쁜 도시의 급한 발걸음을 잊고 몰입의 시간을 통해\n지적인 영감을 얻을 수 있는 공간, 현대카드 디자인\n라이브러리이다.",
            style = typography.ns_r_16,
            color = colors.gray5
        )
    }
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 5.dp,
        color = colors.white2
    )
}

@Composable
private fun SpaceHeaderBannerSection() {
    AsyncImage(
        model = "https://picsum.photos/360/266",
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(360f / 266f)
    )
    SpaceBaseButton(
        "보유 도서 검색하기",
        paddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp)
    )
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpaceScreen() {
    HYUNDAICARDDIVETheme {
    }
}
