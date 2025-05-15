package org.sopt.hyundaicarddive.presentation.ui.space.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SpaceBaseButton(
    text: String,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .background(colors.white),
        border = BorderStroke(1.dp, colors.gray1),
        shape = RoundedCornerShape(3.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(vertical = 14.dp),
            color = colors.black,
            style = typography.ns_sb_14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpaceBaseButtonPreview() {
    HYUNDAICARDDIVETheme {
        SpaceBaseButton("보유 도서 검색하기", PaddingValues(horizontal = 20.dp))
    }
}
