package org.sopt.hyundaicarddive.presentation.ui.home.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.core.util.noRippleClickable
import org.sopt.hyundaicarddive.presentation.type.SortOptionType
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun SortOptionBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    onIndexSelected: (Int) -> Unit = {}
) {
    val contentLists = listOf(
        SortOptionType.RECOMMENDED,
        SortOptionType.LATEST
    )

    Row(
        modifier = modifier
            .padding(start = 30.dp, end = 15.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        contentLists.forEachIndexed { index, content ->
            Text(
                text = content.description,
                color = if (selectedIndex == index) colors.black else colors.gray4,
                style = typography.ns_eb_22,
                modifier = Modifier.noRippleClickable { onIndexSelected(index) }
            )

            if (index == 0){
                VerticalDivider(
                    thickness = 1.dp,
                    color = colors.gray3,
                    modifier = Modifier
                        .height(18.dp)
                        .padding(horizontal = 22.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_spacedetail_booksearch_28),
            contentDescription = null,
            tint = colors.gray5
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSortOptionBar() {
    HYUNDAICARDDIVETheme {
        var selectedIndex by remember { mutableIntStateOf(0) }
        SortOptionBar(
            selectedIndex = selectedIndex,
            onIndexSelected = {selectedIndex = it}
        )
    }
}