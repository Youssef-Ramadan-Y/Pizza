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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.pizza.R

@Composable
fun IconButton(
    stringId: Int, onClickEvent: () -> Unit
) {
    Button(
        onClick = onClickEvent, modifier = Modifier
            .height(55.dp)
            .background(Color.Black, RoundedCornerShape(100.dp)),
        colors = ButtonDefaults.buttonColors(Color.Black)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.background(Color.White)
        )
        Text(
            text = stringResource(stringId),
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewIconButton() {
    IconButton(stringId = R.string.m, onClickEvent = {})
    
}
