package com.pancake.pizza.ui.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class BoxState {
    Small,
    Medium,
    Large,
}

@Composable
fun PizzaSizeButtons() {
    var boxState by remember { mutableStateOf(BoxState.Medium) }

    val offset: Dp by animateDpAsState(
        targetValue = when (boxState) {
            BoxState.Small -> 5.dp
            BoxState.Medium -> 300.dp
            BoxState.Large -> 5.dp
        }
    )
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        SizeButton2(
            modifier = Modifier.wrapContentSize(Alignment.BottomStart)
        )

        Row {
            Text(text = "s", modifier = Modifier.clickable { BoxState.Small })
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "m", modifier = Modifier.clickable { BoxState.Medium })
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "L", modifier = Modifier.clickable { BoxState.Large })
        }

    }
}

@Composable
fun SizeButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Red,
    offset: Dp,
) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .size(50.dp)
            .padding(start = 16.dp)
            .absoluteOffset(x = offset),
        color = Color.Cyan,
        content = {}
    )
}

@Preview
@Composable
fun PreviewPizzaSizeButton() {
    PizzaSizeButtons()
}