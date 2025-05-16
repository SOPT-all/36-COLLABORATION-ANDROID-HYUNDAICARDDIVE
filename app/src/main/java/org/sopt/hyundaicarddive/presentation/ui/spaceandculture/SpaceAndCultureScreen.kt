package org.sopt.hyundaicarddive.presentation.ui.spaceandculture

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.hyundaicarddive.core.component.TopBar
import org.sopt.hyundaicarddive.presentation.model.WhatsOnListModel
import org.sopt.hyundaicarddive.presentation.type.TopBarType
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.whatson.SpaceAndCultureWhatsOnSection
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceAndCultureRoute(
    padding: PaddingValues,
    navigateToDetail: () -> Unit,
    viewModel: SpaceAndCultureViewModel = hiltViewModel(),
) {
    val whatsOnList by viewModel.whatsOnList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getWhatsOnListItems()
    }

    SpaceAndCultureScreen(
        padding = padding,
        navigateToDetail = navigateToDetail,
        whatsOnList = whatsOnList,
    )
}

@Composable
private fun SpaceAndCultureScreen(
    padding: PaddingValues,
    navigateToDetail: () -> Unit,
    whatsOnList: List<WhatsOnListModel>,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
    ){
        Column{
            TopBar(
                topBarType = TopBarType.SPACEANDCULTURE,
            )
            LazyColumn (
            ){
                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    SpaceAndCultureWhatsOnSection(whatsOnList = whatsOnList,)

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
            padding = PaddingValues(),
            navigateToDetail = {},
            whatsOnList = listOf(
                WhatsOnListModel(
                    "05/10(토) ~ 06/29(일)",
                    "현대 회화의 새로운 서사",
                    "Storage 데이비드 살레 국내 최초\n회고전",
                    "스토리지",
                    "이태원",
                    false,
                    "https://github.com/user-attachments/assets/c9e6105a-1e10-4af4-9347-b06f5c36128a",
                ),
                WhatsOnListModel(
                    "05/23(금)",
                    "손민수 Curated 25 박종해",
                    "하이든, 슈베르트, 라벨 피아노 연주회",
                    "스토리지",
                    "이태원",
                    true,
                    "https://github.com/user-attachments/assets/c9e6105a-1e10-4af4-9347-b06f5c36128a",
                ),
                WhatsOnListModel(
                    "05/23(금)",
                    "손민수 Curated 25 박종해",
                    "하이든, 슈베르트, 라벨 피아노 연주회",
                    "스토리지",
                    "이태원",
                    true,
                    "https://github.com/user-attachments/assets/c9e6105a-1e10-4af4-9347-b06f5c36128a",
                ),
            )
        )
    }
}
