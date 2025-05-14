package org.sopt.hyundaicarddive.presentation.ui.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.R
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme

enum class DetailMenuItem(
    val iconRes: Int,
    val stringRes: Int
) {
    SPACE(R.drawable.ic_spacedetail_space_28, R.string.detail_menu_space_title),
    BOOKSEARCH(R.drawable.ic_spacedetail_booksearch_28, R.string.detail_menu_book_search_title),
    RESERVATION(R.drawable.ic_spacedetail_reservation_28, R.string.detail_menu_reservation_title),
    REVIEW(R.drawable.ic_spacedetail_review_28, R.string.detail_menu_review_title),
    BOOK(R.drawable.ic_spacedetail_book_28, R.string.detail_menu_book_title)
}

@Composable
fun DetailMenu() {
    Row(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DetailMenuItem.entries.forEach { menu ->
            DetailMenuItem(menu)
        }
    }
}

@Composable
fun DetailMenuItem(
    menu: DetailMenuItem
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = menu.iconRes),
            contentDescription = stringResource(id = menu.stringRes)
        )

        Text(
            text = stringResource(id = menu.stringRes),
            color = HYUNDAICARDDIVETheme.colors.black,
            style = HYUNDAICARDDIVETheme.typography.ns_m_10
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailMenu() {
    DetailMenu()
}
