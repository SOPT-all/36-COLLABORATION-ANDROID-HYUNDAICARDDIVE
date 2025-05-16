package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component.whatson

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.hyundaicarddive.presentation.model.WhatsOnListModel
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.typography
import timber.log.Timber

@Composable
fun WhatsOnListItem(
    whatsOnListModel: WhatsOnListModel,
    modifier: Modifier = Modifier,
    isLast: Boolean = false,
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .padding(start = 26.dp, end = 24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .background(colors.black, CircleShape)
            )
            VerticalDivider(
                thickness = 1.dp,
                color = colors.gray1,
                modifier = Modifier
                    .fillMaxHeight()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = if (!isLast) 40.dp else 0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    text = whatsOnListModel.date,
                    color = colors.black,
                    style = typography.ns_m_11,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
                Text(
                    text = whatsOnListModel.title,
                    color = colors.black,
                    style = typography.ns_sb_14,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = whatsOnListModel.description,
                    color = colors.gray3,
                    style = typography.ns_m_12_18,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = whatsOnListModel.stage,
                        color = colors.black,
                        style = typography.ns_m_10
                    )
                    VerticalDivider(
                        thickness = 1.dp,
                        color = colors.gray3,
                        modifier = Modifier
                            .height(11.dp)
                            .padding(horizontal = 8.dp)
                    )
                    Text(
                        text = whatsOnListModel.location,
                        color = colors.gray3,
                        style = typography.ns_m_10,
                    )
                    if (whatsOnListModel.isReservable) {
                        VerticalDivider(
                            thickness = 1.dp,
                            color = colors.gray3,
                            modifier = Modifier
                                .height(11.dp)
                                .padding(horizontal = 8.dp)
                        )
                        Text(
                            text = "예매",
                            color = colors.pointGreen,
                            style = typography.ns_m_10,
                        )
                    }
                }
            }
            AsyncImage(
                model = whatsOnListModel.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds
            )
        }
    }
    Timber.tag("zzz").d("whatsOnListModel: ${whatsOnListModel.imageUrl}")
}

@Preview(showBackground = true)
@Composable
private fun PreviewWhatsOnListItem() {
    val model = WhatsOnListModel(
        date = "05/10(토) ~ 06/29(일)",
        title = "현대 회화의 새로운 서사",
        description = "Storage 데이비드 살레 국내 최초\n회고전",
        stage = "스토리지",
        location = "이태원",
        isReservable = true,
        imageUrl = "https://github.com/user-attachments/assets/f35d50b8-0232-40d0-bcb3-bfb86c262c77"
    )
    HYUNDAICARDDIVETheme {

        WhatsOnListItem(
            whatsOnListModel = model,
        )
    }
}
