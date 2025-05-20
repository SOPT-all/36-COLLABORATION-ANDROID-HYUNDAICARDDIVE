package org.sopt.hyundaicarddive.presentation.ui.space.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.util.noRippleClickable
import org.sopt.hyundaicarddive.presentation.model.SpaceReviewModel
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SpaceReviewPager(
    spaceReviewList: List<SpaceReviewModel>,
    pagerState: PagerState,
    onClickLike: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        state = pagerState,
        pageSize = PageSize.Fill,
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) { page ->

        if (page == spaceReviewList.size) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(292f / 200f)
            )
        } else {
            Column(
                modifier = Modifier
                    .padding(end = 20.dp)
            ) {
                AsyncImage(
                    model = spaceReviewList[page].imgUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(292f / 200f)
                )
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = spaceReviewList[page].reviewer + " 님",
                        style = typography.ns_sb_16,
                        color = colors.black,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (spaceReviewList[page].isLiked) {
                                R.drawable.ic_introduce_like_fill_red_24
                            } else {
                                R.drawable.ic_introduce_like_black_24
                            }
                        ),
                        tint = if (spaceReviewList[page].isLiked) colors.pointRed else colors.black,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .noRippleClickable { onClickLike(page) }
                    )
                    Text(
                        text = spaceReviewList[page].likeCount.toString(),
                        style = typography.ns_m_12_18,
                        color = colors.black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    HYUNDAICARDDIVETheme {
    }
}
