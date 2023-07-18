package com.pancake.pizza.ui.composable

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.pizza.R

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(bottom = 8.dp, start = 16.dp, end = 16.dp).height(64.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "",
        )
        Text(text = "Pizza", fontSize = 24.sp , textAlign = TextAlign.Center)
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = R.drawable.ic_favorite),
            contentDescription = "",
        )


    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewAppBar() {
    AppBar()
}