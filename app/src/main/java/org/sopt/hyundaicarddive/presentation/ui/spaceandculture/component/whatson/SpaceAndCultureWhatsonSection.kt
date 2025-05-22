package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.whatson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData
import org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.SpaceAndCultureHeader

@Composable
fun SpaceAndCultureWhatsOnSection(
    whatsOnList: List<SpaceAndCultureWhatsOnData>
) {
    Column {
        SpaceAndCultureHeader(
            title = stringResource(R.string.spaceandculture_header_whatson_title),
            description = null,
            paddingValues = PaddingValues(horizontal = 24.dp),
            hasMoreContent = true
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
