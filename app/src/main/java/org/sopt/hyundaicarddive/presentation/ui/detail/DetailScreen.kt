package org.sopt.hyundaicarddive.presentation.ui.detail

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.component.TopBar
import org.sopt.hyundaicarddive.core.util.toast
import org.sopt.hyundaicarddive.domain.model.DetailArticleData
import org.sopt.hyundaicarddive.domain.model.DetailData
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.presentation.ui.detail.component.DetailDescriptionSection
import org.sopt.hyundaicarddive.presentation.ui.detail.component.DetailPager
import org.sopt.hyundaicarddive.presentation.ui.detail.component.DetailTabBar
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun DetailRoute(
    padding: PaddingValues,
    navigateToSpace: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getDetail()
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            context.toast(it)
            viewModel.clearToastMessage()
        }
    }

    val detailModel by viewModel.detailData.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState(pageCount = {
        detailModel?.articleList?.size ?: 0
    })

    val pageCount = pagerState.pageCount
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pageCount) {
        coroutineScope.launch {
            if (pageCount > 1) {
                while (true) {
                    delay(4000L) // 4초 간격
                    val nextPage = (pagerState.currentPage + 1) % pageCount
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }

    DetailScreen(
        pagerState = pagerState,
        detailModel = detailModel,
        modifier = Modifier.padding(padding),
        navigateToSpace = navigateToSpace,
        onBackClick = {
            onBackClick()
        }
    )
}

@Composable
private fun DetailScreen(
    pagerState: PagerState,
    detailModel: DetailData?,
    modifier: Modifier = Modifier,
    navigateToSpace: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopBar(
            topBarType = TopBarType.DETAIL,
            onBackClick = {
                onBackClick()
            }
        )
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img_spacedetail_logo_hdc_balck),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 12.dp)
            )

            Text(
                text = stringResource(R.string.detail_logo_description),
                modifier = Modifier.padding(top = 8.dp),
                color = colors.black,
                style = typography.ns_sb_14
            )

            DetailDescriptionSection(
                title = stringResource(R.string.detail_tab_bar_address_title),
                content = detailModel?.address.orEmpty(),
                modifier = Modifier.padding(top = 13.dp)
            )

            DetailDescriptionSection(
                title = stringResource(R.string.detail_tab_bar_time_title),
                content = detailModel?.operationTime.orEmpty(),
                modifier = Modifier.padding(top = 3.dp)
            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = colors.white2,
            modifier = Modifier.padding(top = 21.dp)
        )

        DetailTabBar(
            onSpaceClick = {
                navigateToSpace()
            }
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 56.dp)
                .padding(top = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.detail_library_title),
                color = colors.black,
                style = typography.ns_sb_16
            )

            Image(
                painter = painterResource(R.drawable.img_spacedetail_barcord),
                contentDescription = null,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .aspectRatio(360f / 422f)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) {
                detailModel?.articleList?.getOrNull(it)?.let { article ->
                    DetailPager(article = article)
                }
            }

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 22.dp)
                    .align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) colors.white else colors.white40
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color)
                            .size(6.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    HYUNDAICARDDIVETheme {
        DetailScreen(
            pagerState = rememberPagerState(
                pageCount = {
                    4
                }
            ),
            detailModel = DetailData(
                address = "서울시 종로구 북촌로 31-18",
                operationTime = "화~토 12~21시 / 일, 공휴일 12~18시 (설, 추석 연휴 휴관)",
                articleList = listOf(
                    DetailArticleData(
                        imageUrl = "https://github.com/user-attachments/assets/947c4c77-5313-4aee-9a0a-031ecff323b7",
                        title = "경계선을 넘나드는 사진가",
                        subTitle = "4월의 디자이너, 다이안 아버스",
                        date = "2025.04.14"
                    ),
                    DetailArticleData(
                        imageUrl = "https://github.com/user-attachments/assets/c49dfb51-fe48-4822-abe0-53647c47d480",
                        title = "가장 창의적인 시대의 표상",
                        subTitle = "디자인 라이브러리 전권 보유 컬렉션",
                        date = "2025.03.18"
                    ),
                    DetailArticleData(
                        imageUrl = "https://github.com/user-attachments/assets/58d587a3-f902-4a90-bc2a-29b0763b8cda",
                        title = "한국의 디자인 역사를 품다",
                        subTitle = "월간 <디자인> 전권 보유 컬렉션 구축",
                        date = "2025.05.13"
                    ),
                    DetailArticleData(
                        imageUrl = "https://github.com/user-attachments/assets/f61a44c8-ec7c-4462-8c98-1c4f3fd82606",
                        title = "초록의 물결",
                        subTitle = "현대카드 라이브러리 5월의 새 책",
                        date = "2025.05.06"
                    )
                )
            ),
            modifier = Modifier,
            navigateToSpace = {},
            onBackClick = {}
        )
    }
}
