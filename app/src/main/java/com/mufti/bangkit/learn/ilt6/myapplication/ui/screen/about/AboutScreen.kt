package com.mufti.bangkit.learn.ilt6.myapplication.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mufti.bangkit.learn.ilt6.myapplication.R
import com.mufti.bangkit.learn.ilt6.myapplication.ui.theme.MyApplicationTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "My Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .clip(CircleShape)
            )
            Text(
                text = "Mufti Alie Satriawan",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "mufti@mail.com",
                style = MaterialTheme.typography.body1.copy(
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutPreview() {
    MyApplicationTheme() {
        AboutScreen()
    }
}