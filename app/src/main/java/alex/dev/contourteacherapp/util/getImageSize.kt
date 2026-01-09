package alex.dev.contourteacherapp.util

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun getImageSize(configuration: Configuration): Dp {
    val screenWidth = configuration.screenWidthDp.dp
    val imageSize = when {
        screenWidth < 360.dp -> 160.dp
        screenWidth < 420.dp -> 240.dp
        else -> 220.dp
    }
    return imageSize
}