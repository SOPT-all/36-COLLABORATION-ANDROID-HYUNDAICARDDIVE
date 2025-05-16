package org.sopt.hyundaicarddive.presentation.ui.spaceandculture.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme
import org.sopt.hyundaicarddive.ui.theme.HYUNDAICARDDIVETheme.colors

@Composable
fun SpaceAndCultureCardGrid(
    modifier : Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

    }
}

@Composable
fun SpaceAndCultureCard(
    modifier : Modifier = Modifier,
) {
    Column{
        Box(
            modifier = Modifier
                .size(88.dp, 63.dp)
                .background(color = colors.white)
        ){
            Image(
                imageVector = ImageVector.vectorResource(),
            )
        }
    }
}