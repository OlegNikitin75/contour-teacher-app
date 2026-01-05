package alex.dev.common.ui.theme

import alex.dev.common.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

val myFontFamily = FontFamily(
    Font(R.font.pp_neue_montreal_mono_medium, FontWeight.Medium),
    Font(R.font.pp_neue_montreal_mono_book, FontWeight.Normal)
)

object AppTypography {

    val H1 = TextStyle(
        fontFamily = myFontFamily,
        fontSize = 38.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 38.sp,
        letterSpacing = (-0.04).em,
    )
    val H2 = TextStyle(
        fontFamily = myFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 28.sp,
        letterSpacing = (-0.04).em,
    )
    val H3 = TextStyle(
        fontFamily = myFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        letterSpacing = (-0.04).em,
    )

    val T1 = TextStyle(
        fontFamily = myFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 18.sp,
        letterSpacing = (-0.04).em,
    )
    val T2 = TextStyle(
        fontFamily = myFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        letterSpacing = (-0.04).em,
    )
    val L1 = TextStyle(
        fontFamily = myFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 18.sp,
        letterSpacing = (-0.04).em,
    )
}