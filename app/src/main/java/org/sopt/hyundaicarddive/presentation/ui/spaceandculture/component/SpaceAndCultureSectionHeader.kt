package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceAndCultureSectionHeader(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    hasMoreContent: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = HYUNDAICARDDIVETheme.typography.uni_20,
                color = HYUNDAICARDDIVETheme.colors.black
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = description,
                style = HYUNDAICARDDIVETheme.typography.ns_m_12_22,
                color = HYUNDAICARDDIVETheme.colors.gray5
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            if (hasMoreContent) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_spaceculture_btn_space_more),
                    contentDescription = stringResource(R.string.spaceandculture_section_header_btn_space_more),
                    modifier = Modifier
                        .size(width = 48.dp, height = 22.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(
            modifier = Modifier
                .background(HYUNDAICARDDIVETheme.colors.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    HYUNDAICARDDIVETheme {
        SpaceAndCultureSectionHeader(
            stringResource(R.string.spaceandculture_section_header_title_whatson),
            stringResource(R.string.spaceandculture_section_header_description_space),
            hasMoreContent = true
        )
    }
}
