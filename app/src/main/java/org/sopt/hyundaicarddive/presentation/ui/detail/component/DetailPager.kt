package org.sopt.hyundaicarddive.presentation.ui.detail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.presentation.model.DetailArticleModel
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography

@Composable
fun DetailPager(
    article: DetailArticleModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 24.dp, bottom = 42.dp)
        ) {
            Text(
                text = article.title,
                color = colors.white,
                style = typography.ns_sb_20
            )

            Text(
                text = article.subTitle,
                modifier = Modifier.padding(top = 2.dp),
                color = colors.white,
                style = typography.ns_sb_14
            )

            Text(
                text = article.date,
                modifier = Modifier.padding(top = 7.dp),
                color = colors.white,
                style = typography.ns_sb_14
            )
        }
    }

}

@Preview
@Composable
private fun PreviewDetailPager() {

}