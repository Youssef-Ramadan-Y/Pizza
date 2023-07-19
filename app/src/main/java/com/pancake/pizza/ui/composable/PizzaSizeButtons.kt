package com.pancake.pizza.ui.composable

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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

enum class BoxState {
    Small,
    Medium,
    Large,
}

@OptIn(ExperimentalFoundationApi::class)
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
            180f -> (-66).dp
            200f -> 0.dp
            220f -> 66.dp
            else -> 0.dp
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
            modifier = Modifier.wrapContentSize(Alignment.BottomStart)
        )

        Row {
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
//            Spacer(modifier = Modifier.width(16.dp))
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
//            Spacer(modifier = Modifier.width(16.dp))
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
    Card(
        modifier = modifier
            .size(42.dp)
            .absoluteOffset(x = offset)
            .clip(CircleShape)
            .shadow(elevation = 5.dp, spotColor = Color.Black)
            .background(Color.White),
        content = {}
    )
}

@Preview
@Composable
fun PreviewPizzaSizeButton(

) {
//    PizzaSizeButtons(state)
}