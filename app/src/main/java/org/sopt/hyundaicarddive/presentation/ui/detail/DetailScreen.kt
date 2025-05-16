package org.sopt.hyundaicarddive.presentation.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.component.TopBar
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.presentation.ui.detail.component.DetailDescriptionSection
import org.sopt.hyundaicarddive.presentation.ui.detail.component.DetailTabBar
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun DetailRoute(
    padding: PaddingValues,
    navigateToSpace: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 4 })

    DetailScreen(
        pagerState = pagerState,
        modifier = Modifier.padding(padding),
        navigateToSpace = navigateToSpace
    )
}

@Composable
private fun DetailScreen(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navigateToSpace: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopBar(topBarType = TopBarType.DETAIL)
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img_spacedetail_logo_hdc_balck),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .clickable {
                        navigateToSpace()
                    }
            )

            Text(
                text = stringResource(R.string.detail_logo_description),
                modifier = Modifier.padding(top = 8.dp),
                color = colors.black,
                style = typography.ns_sb_14
            )

            DetailDescriptionSection(
                title = stringResource(R.string.detail_tab_bar_address_title),
                content = stringResource(R.string.detail_tab_bar_address_content),
                modifier = Modifier.padding(top = 13.dp)
            )

            DetailDescriptionSection(
                title = stringResource(R.string.detail_tab_bar_time_title),
                content = stringResource(R.string.detail_tab_bar_time_content),
                modifier = Modifier.padding(top = 3.dp)
            )
        }


        HorizontalDivider(
            thickness = 1.dp,
            color = colors.white2,
            modifier = Modifier.padding(top = 21.dp)
        )

        DetailTabBar()

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
                .aspectRatio(360f / 422f)
        ) {
            HorizontalPager(
                state = pagerState,
            ) {
                Box {
                    AsyncImage(
                        model = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400",
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 24.dp, bottom = 42.dp)
                    ) {
                        Text(
                            text = "1",
                            color = colors.white,
                            style = typography.ns_sb_20
                        )

                        Text(
                            text = "1",
                            modifier = Modifier.padding(top = 2.dp),
                            color = colors.white,
                            style = typography.ns_sb_14
                        )

                        Text(
                            text = "1",
                            modifier = Modifier.padding(top = 7.dp),
                            color = colors.white,
                            style = typography.ns_sb_14
                        )
                    }
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
            modifier = Modifier,
            navigateToSpace = {}
        )
    }
}
