package org.sopt.hyundaicarddive.presentation.ui.detail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun DetailInfo(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentSize()
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(end = 25.dp),
            color = HYUNDAICARDDIVETheme.colors.black,
            style = HYUNDAICARDDIVETheme.typography.ns_sb_12
        )

        Text(
            text = content,
            modifier = Modifier.fillMaxWidth(),
            color = HYUNDAICARDDIVETheme.colors.black,
            style = HYUNDAICARDDIVETheme.typography.ns_r_12
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailInfo() {
    DetailInfo(
        title = stringResource(R.string.detail_address_title),
        content = "내용"
    )
}
