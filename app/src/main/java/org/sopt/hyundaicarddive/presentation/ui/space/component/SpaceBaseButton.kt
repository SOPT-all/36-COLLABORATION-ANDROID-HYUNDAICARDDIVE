package org.sopt.hyundaicarddive.presentation.ui.space.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

@Composable
fun SpaceBaseButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .size(width = 320.dp, height = 48.dp)
            .background(HYUNDAICARDDIVETheme.colors.white),
        border = BorderStroke(1.dp, HYUNDAICARDDIVETheme.colors.gray1),
        shape = RoundedCornerShape(3.dp),
    ) {
        Text(
            text = text,
            color = HYUNDAICARDDIVETheme.colors.black,
            style = HYUNDAICARDDIVETheme.typography.ns_sb_14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    HYUNDAICARDDIVETheme {
        SpaceBaseButton("보유 도서 검색하기")
    }
}