package org.example.invitation

import androidx.compose.runtime.Composable
import androidx.compose.material.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import invitation.composeapp.generated.resources.Hahmlet_Bold
import invitation.composeapp.generated.resources.Hahmlet_ExtraBold
import invitation.composeapp.generated.resources.Hahmlet_ExtraLight
import invitation.composeapp.generated.resources.Hahmlet_Light
import invitation.composeapp.generated.resources.Hahmlet_Medium
import invitation.composeapp.generated.resources.Hahmlet_Regular
import invitation.composeapp.generated.resources.Hahmlet_SemiBold
import invitation.composeapp.generated.resources.Hahmlet_Thin
import invitation.composeapp.generated.resources.NotoColorEmoji
import invitation.composeapp.generated.resources.NotoSansKR_Bold
import invitation.composeapp.generated.resources.NotoSansKR_ExtraBold
import invitation.composeapp.generated.resources.NotoSansKR_Medium
import invitation.composeapp.generated.resources.NotoSansKR_SemiBold
import invitation.composeapp.generated.resources.NotoSansKR_Thin
import invitation.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


val fontFamily
    @Composable
    get() = Typography().run {
        val fontFamily = FontFamily(
            Font(
                Res.font.NotoColorEmoji,
                weight = FontWeight.Medium,
            ),
            Font(
                Res.font.NotoSansKR_Medium,
                weight = FontWeight.Normal,
            ),
            Font(
                Res.font.Hahmlet_SemiBold,
                weight = FontWeight.Bold,
            ),
            Font(
                Res.font.NotoSansKR_ExtraBold,
                weight = FontWeight.ExtraBold,
            ),
            Font(
                Res.font.Hahmlet_ExtraLight,
                weight = FontWeight.ExtraLight,
            ),
            Font(
                Res.font.Hahmlet_Light,
                weight = FontWeight.Light,
            ),
            Font(
                Res.font.NotoSansKR_SemiBold,
                weight = FontWeight.SemiBold,
            ),

            Font(
                Res.font.NotoColorEmoji,
                weight = FontWeight.Thin,
            ),
            Font(
                Res.font.NotoColorEmoji,
                weight = FontWeight.W500,
            ),
        )

        copy(
            h1 = h1.copy(
                lineHeight = 52.17.sp,
                fontSize = 40.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9A70E2),
            ),
            h2 = h2.copy(
                lineHeight = 52.17.sp,
                fontSize = 40.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            ),
            h3 = h3.copy(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            ),
            h4 = h4.copy(fontFamily = fontFamily),
            h5 = h5.copy(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFCBED9A),
            ),
            h6 = h6.copy(
                fontFamily = fontFamily,
                color = Color.White,
                //fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 26.5.sp
            ),
            subtitle1 = subtitle1.copy(
                fontFamily = fontFamily,
                color = Color(0xFF9A70E2),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            ),
            subtitle2 = subtitle2.copy(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF9A70E2),
            ),
            body1 = body1.copy(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Thin,
                color = Color.White,
                letterSpacing = (-1.5).sp,
//                platformStyle = PlatformTextStyle(
//                    emojiSupportMatch = EmojiSupportMatch.None
//                )
            ),
            body2 = body2.copy(fontFamily = fontFamily),
            button = button.copy(
                fontFamily = fontFamily,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 0.sp,
            ),
            caption = caption.copy(
                fontFamily = fontFamily,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 26.sp,
                lineHeight = 34.sp
            ),
            overline = overline.copy(
                fontFamily = fontFamily,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 26.5.sp
            )
        )
    }