package alex.dev.contourteacherapp.presentation.ui.componets.layout

import alex.dev.contourteacherapp.presentation.ui.theme.AccentTeacher
import alex.dev.contourteacherapp.presentation.ui.theme.AppGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppLightGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.titles.AppTitle
import alex.dev.contourteacherapp.util.getImageSize
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToIntroScreen: () -> Unit,
) {
    val configuration = LocalConfiguration.current
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
                        .size(size = getImageSize(configuration))
                        .padding(bottom = AppSize.SIZE_MEDIUM),
                    painter = painterResource(R.drawable.teacher_icon_splash),
                    contentDescription = stringResource(R.string.teacher_image_d),
                )
                AppTitle()
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
