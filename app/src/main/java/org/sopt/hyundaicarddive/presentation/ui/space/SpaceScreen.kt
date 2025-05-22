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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.util.toast
import org.sopt.hyundaicarddive.presentation.model.SpaceModel
import org.sopt.hyundaicarddive.presentation.model.SpaceReviewModel
import org.sopt.hyundaicarddive.presentation.ui.space.component.SpaceBaseButton
import org.sopt.hyundaicarddive.presentation.ui.space.component.SpaceCautionGrid
import org.sopt.hyundaicarddive.presentation.ui.space.component.SpaceReviewPager
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SpaceRoute(
    padding: PaddingValues,
    onBackClick: () -> Unit,
    viewModel: SpaceViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    val reviewList by viewModel.reviewList.collectAsStateWithLifecycle()
    val spaceModel by viewModel.spaceModel.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getSpace()
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            context.toast(it)
            viewModel.clearToastMessage()
        }
    }

    val pagerState = rememberPagerState(pageCount = {
        reviewList.size
    })

    SpaceScreen(
        padding = padding,
        onBackClick = onBackClick,
        onClickLike = viewModel::toggleLike,
        reviewList = reviewList,
        pagerState = pagerState,
        spaceModel = spaceModel
    )
}

@Composable
private fun SpaceScreen(
    padding: PaddingValues,
    onBackClick: () -> Unit,
    onClickLike: (Int) -> Unit,
    pagerState: PagerState,
    reviewList: List<SpaceReviewModel>,
    spaceModel: SpaceModel?,
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
                spaceModel ?: return@item

                SpaceHeaderBannerSection(imageUrl = spaceModel.bannerUrl)

                SpaceIntroductionSection(contentDescription = spaceModel.introduction)

                SpaceLocationSection(address = spaceModel.address)

                SpaceCrowdInfoSection()

                SpaceReviewSection(
                    reviewList = reviewList,
                    onClickLike = onClickLike,
                    pagerState = pagerState
                )

                SpaceContactSection(
                    tel = spaceModel.telephone,
                    email = spaceModel.email
                )

                SpaceCautionSection()
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.black)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.space_button_reservation),
                style = typography.ns_sb_16,
                color = colors.white,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }
    }
}

@Composable
private fun SpaceCautionSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 80.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.space_caution_title),
            style = typography.ns_sb_20,
            color = colors.black
        )
        SpaceCautionGrid()
    }
}

@Composable
private fun SpaceContactSection(
    tel: String,
    email: String
) {
    Column(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.space_contact_title),
            style = typography.ns_sb_20,
            color = colors.black
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.space_contact_tel_title),
                style = typography.ns_sb_16,
                color = colors.black,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = tel,
                style = typography.ns_r_16,
                color = colors.black
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 5.dp)
        ) {
            Text(
                text = stringResource(R.string.space_contact_email_title),
                style = typography.ns_sb_16,
                color = colors.black,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = email,
                style = typography.ns_r_16,
                color = colors.black
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )
}

@Composable
private fun SpaceReviewSection(
    reviewList: List<SpaceReviewModel>,
    onClickLike: (Int) -> Unit,
    pagerState: PagerState
) {
    Text(
        text = stringResource(R.string.space_review_title),
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
                text = stringResource(R.string.space_review_description),
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
            text = stringResource(R.string.space_crowd_info_title),
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
private fun SpaceLocationSection(
    address: String
) {
    Text(
        text = stringResource(R.string.space_location_title),
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
            text = address,
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
        text = stringResource(R.string.space_base_button_map),
        paddingValues = PaddingValues(top = 16.dp, bottom = 24.dp, start = 20.dp, end = 20.dp)
    )
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )
}

@Composable
private fun SpaceIntroductionSection(
    contentDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            text = stringResource(R.string.space_introduction_title),
            style = typography.ns_sb_20,
            color = colors.black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = contentDescription,
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
private fun SpaceHeaderBannerSection(
    imageUrl: String
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(360f / 266f)
    )
    SpaceBaseButton(
        text = stringResource(id = R.string.space_base_button_search),
        paddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp)
    )
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 12.dp,
        color = colors.white2
    )
}
