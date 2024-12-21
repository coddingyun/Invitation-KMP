package org.example.invitation

//import VideoPlayer
//import MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import invitation.composeapp.generated.resources.Res
import invitation.composeapp.generated.resources.christmas_banner
import invitation.composeapp.generated.resources.daejeon
import invitation.composeapp.generated.resources.gallery_image1
import invitation.composeapp.generated.resources.gallery_image2
import invitation.composeapp.generated.resources.gallery_image3
import invitation.composeapp.generated.resources.gallery_image4
import invitation.composeapp.generated.resources.gallery_image4_2
import invitation.composeapp.generated.resources.gallery_image5
import invitation.composeapp.generated.resources.gallery_image6
import invitation.composeapp.generated.resources.gallery_image0
import org.jetbrains.compose.resources.DrawableResource

class App {
    @Composable
    fun Content() {
        MaterialTheme {
            MainViews()
        }
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
            item {
                Image(
                    painter = painterResource(resource = Res.drawable.christmas_banner),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.3f)
                        .padding(vertical = 10.dp),
                    contentDescription = "christmas banner"
                )
            }

            item {
                Text("크리스마스 파티에 \n 초대합니다!",
                    style = fontFamily.h3,
                    modifier = Modifier.padding(vertical = 20.dp),
                    textAlign = TextAlign.Center,
                )
            }

            item {
                Text(
                    """
                        2024년 12월 25일 (수)
                        09:00 AM 대전
                    """.trimIndent(),
                    style = fontFamily.body2,
                    color = Color(0xFFDBB683),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(vertical = 15.dp),
                    textAlign = TextAlign.Center
                )
            }

//            item {
//                YoutubePlayer()
//            }

            item {
                Text(
                    """
                        추워지면 돌아오는 
                        
                        BMHICS의 
                        
                        크리스마스 파티,
                        
                        그 4번째 파티에 
                        
                        여러분을 초대합니다.
                    """.trimIndent(),
                    style = fontFamily.overline,
//                    style = TextStyle(
//                        fontFamily = FontFamily(
//                            Font(Res.font.NotoSansKR_Regular, weight = FontWeight.Medium)
//                        ),
//                        color = Color.White,
//                        fontSize = 16.sp,
//                    ),
                    modifier = Modifier.padding(vertical = 60.dp),
                    textAlign = TextAlign.Center
                )
            }

            item {
                SubTitle("💚준비물💚")
            }

            item {
                Text(
                    """
                        🎁1만원 이하의 랜덤 선물🎁
                        🙊쌓아둔 재미난 썰들🙊
                        🌟정신 머리와 체력🌟
                    """.trimIndent(),
                    style = fontFamily.body1,
                    textAlign = TextAlign.Center
                )
            }

            item {
                SubTitle("💃🏼드레스 코드💃🏼")
            }

            item {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    DressCodeCircle(Color.Red, "Red", Color.White)
                    DressCodeCircle(Color(0xFF126333), "Green", Color.White)
                    DressCodeCircle(Color.White, "White", Color.Red)
                }
            }

            item {
                SubTitle("❄️Winter Gallery❄️")
            }

            item {
                GalleryImage(Res.drawable.gallery_image0, -15f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image1, 20f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image2, -20f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image3, 15f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image4, -30f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image4_2, 10f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image5, -15f)
            }

            item {
                GalleryImage(Res.drawable.gallery_image6, 5f)
            }

            item {
                Text(
                    //"Hello $EMOJI_TEXT",
                    """
                        💚️❤️💚
                        이번 크리스마스에 갤러리를 더 채워봐요
                        ❤️💚❤️
                    """.trimIndent(),
                    style = fontFamily.body1,
                    modifier = Modifier.padding(vertical = 15.dp),
                    textAlign = TextAlign.Center
                )
            }

            item {
                SubTitle("오시는 길")
            }

            item {
                Image(
                    painter = painterResource(resource = Res.drawable.daejeon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp, start = 30.dp, end = 30.dp),
                    contentDescription = "map daejeon"
                )
            }

            item {
                val uriHandler = LocalUriHandler.current
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(bottom = 10.dp),
                ){
                    CustomButton("네이버 지도") {
                            uriHandler.openUri("https://naver.me/F5DpdrkZ")
                    }
                    CustomButton("카카오맵") {
                        uriHandler.openUri("https://kko.kakao.com/UoL1fuuRsf")
                    }
                }
            }

        }
    }
}

@Composable
fun SubTitle(text: String) {
    Text(
        text,
        style = fontFamily.h5,
        modifier = Modifier.padding(
            top = 150.dp,
            bottom = 30.dp
        ),
    )
}

@Composable
fun GalleryImage(res: DrawableResource, rotationLevel: Float) {
    Image(
        painter = painterResource(resource = res),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.3f)
            .padding(vertical = 30.dp, horizontal = 20.dp)
            .graphicsLayer {
                rotationZ = rotationLevel
            },
        contentDescription = "gallery image"
    )
}

@Composable
fun CustomButton(buttonText: String, handleClick: () -> Unit) {
    Button(
        onClick = handleClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF126333),
            contentColor = Color.White,
        )
    ) {
        Text(buttonText)
    }
}

@Composable
fun DressCodeCircle(color: Color, text: String, textColor: Color) {
    Box (
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center,
    )
    {
        Text(
            text,
            //style = fontFamily.body2,
            color = textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        )
    }
}

//@Composable
//fun YoutubePlayer() {
//    VideoPlayer(
//        modifier = Modifier.fillMaxWidth(),
//        url = "https://www.youtube.com/watch?v=RCJ0W6PvHAE",
//        autoPlay = true,
//    )
//}
