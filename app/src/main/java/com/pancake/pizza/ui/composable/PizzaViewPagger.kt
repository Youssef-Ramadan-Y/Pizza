package com.pancake.pizza.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.pancake.pizza.R
import com.pancake.pizza.ui.screens.Ingredients
import com.pancake.pizza.ui.screens.OrderUiState

// todo 2

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PizzaViewPager(
    state: OrderUiState,
    pagerState: PagerState,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.4f),
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
            modifier = Modifier.fillMaxWidth(),
            count = state.pizzaList.size,
            state = pagerState,

            ) { page ->

            Box() {
                Image(
                    modifier = Modifier
                        .size(state.pizzaList[page].pizzaSize.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = state.pizzaList[page].image),
                    contentDescription = "Pizza"
                )
            }



            state.pizzaList[pagerState.currentPage].ingredients.forEach { ingredient ->
                IngredientAnimation(state = ingredient, size = state.pizzaList[page].pizzaSize)
            }
        }
    }


}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun IngredientAnimation(state: Ingredients, size : Float) {

    AnimatedVisibility(
        visible = state.isSelected,
        enter = scaleIn(initialScale = 4f) + fadeIn(),
        exit = fadeOut()
    ) {
        Image(
            modifier = Modifier.size(size.dp),
            painter = painterResource(id = state.image),
            contentDescription = "plate",
        )
    }
}

@Preview
@Composable
fun PreviewPizzaViewPager() {

}