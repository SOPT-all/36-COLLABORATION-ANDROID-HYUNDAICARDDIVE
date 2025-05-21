package org.sopt.hyundaicarddive.presentation.ui.spaceandculture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.component.TopBar
import org.sopt.hyundaicarddive.core.util.toast
import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData
import org.sopt.hyundaicarddive.presentation.type.SpaceAndCultureGridItem
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.SpaceAndCultureCardGrid
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.SpaceAndCultureHeader
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.whatson.SpaceAndCultureWhatsOnSection
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceAndCultureRoute(
    padding: PaddingValues,
    navigateToDetail: () -> Unit,
    viewModel: SpaceAndCultureViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val errorMessage by viewModel.errorMessage.collectAsStateWithLifecycle()

    val whatsOnList by viewModel.whatsOnList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getWhatsOnList()
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            context.toast(it)
            viewModel.clearToastMessage()
        }
    }

    SpaceAndCultureScreen(
        navigateToDetail = navigateToDetail,
        whatsOnList = whatsOnList,
        spaceList = viewModel.spaceListItems,
        cultureList = viewModel.cultureListItems,
        modifier = Modifier.padding(padding)
    )
}

@Composable
private fun SpaceAndCultureScreen(
    navigateToDetail: () -> Unit,
    whatsOnList: List<SpaceAndCultureWhatsOnData>,
    spaceList: List<SpaceAndCultureGridItem>,
    cultureList: List<SpaceAndCultureGridItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBar(
            topBarType = TopBarType.SPACEANDCULTURE
        )
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(15.dp))
                SpaceAndCultureWhatsOnSection(whatsOnList = whatsOnList)
            }
            item {
                Column {
                    SpaceAndCultureHeader(
                        title = stringResource(R.string.spaceandculture_header_space_title),
                        description = stringResource(R.string.spaceandculture_header_space_description),
                        paddingValues = PaddingValues(start = 24.dp, end = 24.dp, top = 42.dp, bottom = 16.dp)
                    )
                    SpaceAndCultureCardGrid(
                        cards = spaceList,
                        navigateToDetail = navigateToDetail
                    )
                }
            }
            item {
                Column {
                    SpaceAndCultureHeader(
                        title = stringResource(R.string.spaceandculture_header_culture_title),
                        description = stringResource(R.string.spaceandculture_header_culture_description),
                        paddingValues = PaddingValues(start = 24.dp, end = 24.dp, top = 36.dp, bottom = 16.dp)
                    )
                    SpaceAndCultureCardGrid(
                        cards = cultureList
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpaceAndCultureScreen() {
    HYUNDAICARDDIVETheme {
        SpaceAndCultureScreen(
            navigateToDetail = {},
            whatsOnList = listOf(
                SpaceAndCultureWhatsOnData(
                    "05/10(토) ~ 06/29(일)",
                    "현대 회화의 새로운 서사",
                    "Storage 데이비드 살레 국내 최초\n회고전",
                    "스토리지",
                    "이태원",
                    false,
                    "https://github.com/user-attachments/assets/c9e6105a-1e10-4af4-9347-b06f5c36128a"
                ),
                SpaceAndCultureWhatsOnData(
                    "05/23(금)",
                    "손민수 Curated 25 박종해",
                    "하이든, 슈베르트, 라벨 피아노 연주회",
                    "스토리지",
                    "이태원",
                    true,
                    "https://github.com/user-attachments/assets/c9e6105a-1e10-4af4-9347-b06f5c36128a"
                ),
                SpaceAndCultureWhatsOnData(
                    "05/23(금)",
                    "손민수 Curated 25 박종해",
                    "하이든, 슈베르트, 라벨 피아노 연주회",
                    "스토리지",
                    "이태원",
                    true,
                    "https://github.com/user-attachments/assets/c9e6105a-1e10-4af4-9347-b06f5c36128a"
                )
            ),
            spaceList = listOf(),
            cultureList = listOf()
        )
    }
}
