package com.pancake.pizza.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.pizza.R
import com.pancake.pizza.ui.theme.Brown

@Composable
fun IconButton(
    modifier: Modifier = Modifier, stringId: Int, onClickEvent: () -> Unit,
) {
    Button(
        onClick = onClickEvent, modifier = modifier
            .height(55.dp)
            .background(Brown, RoundedCornerShape(16.dp)),
        colors = ButtonDefaults.buttonColors(Brown)
    ) {
        Icon(
            modifier = Modifier.padding(start = 8.dp,end = 8.dp),
            painter = painterResource(id = R.drawable.ic_shopping_cart),
            contentDescription = "shopping icon"
        )
        Text(
            text = stringResource(stringId),
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewIconButton() {
    IconButton(stringId = R.string.m, onClickEvent = {})
    
}
