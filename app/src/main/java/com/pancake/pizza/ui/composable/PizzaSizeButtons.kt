package com.pancake.pizza.ui.composable

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.pizza.ui.screens.OrderUiState
import com.pancake.pizza.util.PizzaSizes

enum class BoxState {
    Small,
    Medium,
    Large,
}

@Composable
fun PizzaSizeButtons(
    state: OrderUiState,
    pagerState: Int,
    onSmallClicked: () -> Unit,
    onMediumClicked: () -> Unit,
    onLargeClicked: () -> Unit,
) {
    var boxState by remember { mutableStateOf(BoxState.Medium) }

    val offset: Dp by animateDpAsState(
        targetValue = when (state.pizzaList[pagerState].pizzaSize) {
            PizzaSizes.Small -> (-66).dp
            PizzaSizes.Medium -> 0.dp
            PizzaSizes.Large -> 66.dp
        },
        animationSpec = tween(
            durationMillis = 500,
            delayMillis = 50,
            easing = CubicBezierEasing(.60f, 0f, .5f, .2f),
        )
    )



    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        SizeButton(
            offset = offset,
            modifier = Modifier.wrapContentSize(Alignment.Center)
        )

        Row(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Button(
                onClick = {
                    boxState = BoxState.Small
                    onSmallClicked()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "S", fontSize = 24.sp, color = Color.Black)
            }
            Button(
                onClick = {
                    boxState = BoxState.Medium
                    onMediumClicked()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "M", fontSize = 24.sp, color = Color.Black)
            }
            Button(
                onClick = {
                    boxState = BoxState.Large
                    onLargeClicked()
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = "L", fontSize = 24.sp, color = Color.Black)
            }
        }
    }
}



@Composable
fun SizeButton(
    modifier: Modifier = Modifier,
    offset: Dp,
) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .fillMaxSize()
            .absoluteOffset(x = offset)
            .shadow(
                elevation = 6.dp,
                shape = CircleShape,
                ambientColor = Color.Black,
                spotColor = Color.Black
            )
            .clip(CircleShape)
            .background(Color.White)
    )
}

@Preview
@Composable
fun PreviewPizzaSizeButton(

) {
    PizzaSizeButtons(
        OrderUiState(),
        1,
        {},
        {},
        {}
    )
}