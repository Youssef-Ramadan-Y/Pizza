package com.pancake.pizza.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SizeButton2(modifier: Modifier = Modifier, offset: Dp) {
    Box(
        modifier = modifier
            .size(24.dp)
            .absoluteOffset(x = offset)
            .clip(CircleShape)
            .shadow(elevation = 3.dp)
            .background(Color.Black),
    )
}


@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewSizeButton() {

}
