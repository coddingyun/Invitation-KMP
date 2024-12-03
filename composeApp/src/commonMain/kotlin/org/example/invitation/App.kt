package org.example.invitation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import invitation.composeapp.generated.resources.Res
import invitation.composeapp.generated.resources.christmas_banner

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainViews()
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainViews() {
    val windowSizeClass = calculateWindowSizeClass()

    val boxModifier = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> Modifier.fillMaxWidth() // 모바일 화면(Compact): 전체 너비 차지
        //WindowWidthSizeClass.Medium -> Modifier.width(200.dp)   // Medium 화면: 200dp 고정
        WindowWidthSizeClass.Expanded -> Modifier.width(500.dp) // PC 화면(Expanded): 400dp 고정
        else -> Modifier.fillMaxWidth() // 기본값: 모바일과 동일
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .then(boxModifier)
            .background(Color(0xFFAE131B)),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                Image(
                    painter = painterResource(resource = Res.drawable.christmas_banner),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.3f),
                    contentDescription = "christmas banner"
                )
            }
            items(50) { index ->
                Text("Inner text #$index")
            }
        }
    }
}
