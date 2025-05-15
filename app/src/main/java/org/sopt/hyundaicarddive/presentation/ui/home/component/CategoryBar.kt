package org.sopt.hyundaicarddive.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.core.util.noRippleClickable
import org.sopt.hyundaicarddive.presentation.type.CategoryType
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun CategoryBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    onIndexSelected: (Int) -> Unit = {}
) {
    val contentLists = listOf(
        CategoryType.TOTAL.description,
        CategoryType.DESIGN.description,
        CategoryType.BUILDING.description,
        CategoryType.TRIP.description,
        CategoryType.MUSIC.description,
        CategoryType.COOKING.description,
        CategoryType.STYLE.description,
        CategoryType.TECH.description,
        CategoryType.SPECIAL.description
    )

    LazyRow(
        modifier = modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(contentLists.size) { index ->
            if (index == 0) {
                Spacer(Modifier.width(30.dp))
            }

            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = if (selectedIndex == index) Color.Transparent else colors.gray2,
                        shape = RoundedCornerShape(100.dp)
                    )
                    .background(
                        color = if (selectedIndex == index) colors.black else colors.white,
                        shape = RoundedCornerShape(100.dp)
                    )
                    .noRippleClickable {
                        onIndexSelected(index)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contentLists[index],
                    style = typography.ns_sb_12,
                    color = if (selectedIndex == index) colors.white else colors.gray5,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 7.dp
                        )
                )
            }

            if (index == contentLists.size - 1) {
                Spacer(Modifier.width(30.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCategoryBar() {
    HYUNDAICARDDIVETheme {
        var selectedIndex by remember { mutableIntStateOf(0) }
        CategoryBar(
            selectedIndex = selectedIndex,
            onIndexSelected = { selectedIndex = it }
        )
    }
}
