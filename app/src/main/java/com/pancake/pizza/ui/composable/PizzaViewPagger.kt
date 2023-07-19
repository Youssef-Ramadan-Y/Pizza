package com.pancake.pizza.ui.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.pancake.pizza.R
import com.pancake.pizza.ui.screens.OrderUiState

// todo 2

enum class PizzaState {
    Small,
    Medium,
    Large,
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PizzaViewPager(
    state: OrderUiState,
    pagerState: PagerState,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val floatTransition by  infiniteTransition.animateFloat(
        initialValue = 64f,
        targetValue = 280f,
        animationSpec = InfiniteRepeatableSpec(
            tween(5000),
            RepeatMode.Reverse,
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .size(250.dp),
            painter = painterResource(id = R.drawable.plate),
            contentDescription = null,
        )

        // the view pager here
        HorizontalPager(
            modifier = Modifier.align(Alignment.Center),
            count = state.pizzaList.size,
            state = pagerState,

            ) { page ->
            Box() {
                Image(
                    modifier = Modifier
                        .animateContentSize()
                        .size(state.pizzaList[page].pizzaSize.dp),
                    painter = painterResource(id = state.pizzaList[page].image),
                    contentDescription = "Pizza"
                )
                if (state.pizzaList[page].ingredients.isNotEmpty()) {
                    for (ingredient in state.pizzaList[page].ingredients) {
                        Image(
                            modifier = Modifier
                                .size(floatTransition.dp),
                            painter = painterResource(id = ingredient.image),
                            contentDescription = "Pizza"
                        )
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewPizzaViewPager() {

}