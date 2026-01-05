package alex.dev.contourteacherapp.presentation.ui.componets.layout

import alex.dev.common.ui.components.titles.AppTitle
import alex.dev.common.ui.theme.AccentTeacher
import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.common.ui.theme.AppSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToIntroScreen: () -> Unit,
    image: Painter,
    contentDescription: String,
    subTitle: String,
    accentColor: Color = AccentTeacher
) {
    val scale = remember { Animatable(0.7f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )
        delay(2000L)
        navigateToIntroScreen()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppLightGray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .scale(scale.value)
                .alpha(alpha.value),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(240.dp)
                        .padding(bottom = AppSize.SIZE_MEDIUM),
                    painter = image,
                    contentDescription = contentDescription,
                )
                AppTitle(
                    appSubTitle = subTitle,
                    accentColor = accentColor
                )
            }

            Column(
                modifier = Modifier
                    .padding(bottom = AppSize.SIZE_EXTRA_LARGE),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .width(150.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    color = AccentTeacher,
                    trackColor = AppGray
                )
            }
        }
    }
}
