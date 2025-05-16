package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.whatson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.presentation.model.WhatsOnListModel
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.SpaceAndCultureHeader
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceAndCultureWhatsOnSection(
    whatsOnList: List<WhatsOnListModel>,
) {
    Column {
        SpaceAndCultureHeader(
            title = stringResource(R.string.spaceandculture_header_whatson_title),
            description = null,
            paddingValues = PaddingValues(horizontal = 24.dp),
            hasMoreContent = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        whatsOnList.forEachIndexed { index, item ->
            WhatsOnListItem(
                whatsOnListModel = item,
                isLast = index == whatsOnList.lastIndex
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpaceAndCultureWhatsOnSection() {
    HYUNDAICARDDIVETheme {
        SpaceAndCultureWhatsOnSection(
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
                )
            )
        )
    }
}
