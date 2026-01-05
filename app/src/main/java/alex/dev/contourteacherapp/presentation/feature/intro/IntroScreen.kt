package alex.dev.contourteacherapp.presentation.feature.intro

import alex.dev.common.ui.components.buttons.PrimaryButton
import alex.dev.common.ui.components.titles.AppTitle
import alex.dev.common.ui.theme.AppBlack
import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.common.ui.theme.AppSize
import alex.dev.common.ui.theme.AppTypography
import alex.dev.common.ui.theme.AppWhite
import alex.dev.common.ui.theme.Resources
import alex.dev.contour.teacher.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun IntroScreen(
    onNavigateToSignUp: () -> Unit,
    onNavigateToSignIn: () -> Unit
) {
//    val configuration = LocalConfiguration.current
//    val screenWidth = configuration.screenWidthDp.dp
//    val imageSize = when {
//        screenWidth < 360.dp -> 160.dp
//        screenWidth < 420.dp -> 240.dp
//        else -> 220.dp
//    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppLightGray,
    ) { paddingValues ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val (titleRef, imageRef, surfaceRef) = createRefs()
            AppTitle(
                modifier = Modifier
                    .constrainAs(titleRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                appSubTitle = stringResource(R.string.app_sub_title),
                textStyle = AppTypography.H3,
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(surfaceRef) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                color = AppWhite,
                shape = RoundedCornerShape(
                    topStart = AppSize.SIZE_MEDIUM,
                    topEnd = AppSize.SIZE_MEDIUM
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = AppSize.SIZE_MEDIUM,
                            bottom = AppSize.SIZE_MEDIUM,
                            start = AppSize.SIZE_NORMAL,
                            end = AppSize.SIZE_NORMAL
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(AppSize.SIZE_MEDIUM)
                ) {
                    Text(
                        text = stringResource(R.string.subtitle_intro),
                        style = AppTypography.H2,
                        color = AppBlack,
                        textAlign = TextAlign.Center
                    )
                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AppSize.SIZE_EXTRA_LARGE),
                        onClick = onNavigateToSignUp,
                        label = stringResource(Resources.LabelsOnButtons.SignUp),
                        containerColor = AppBlack,
                        contentColor = AppWhite
                    )
                    Row {
                        Text(
                            modifier = Modifier.clickable { onNavigateToSignIn() },
                            text = stringResource(Resources.Strings.HaveAnAccount),
                            color = AppGray,
                            style = AppTypography.L1
                        )
                        Spacer(modifier = Modifier.width(AppSize.SIZE_SMALL))
                        Text(
                            modifier = Modifier.clickable { onNavigateToSignIn() },
                            text = stringResource(Resources.LabelsOnButtons.SignIn),
                            color = AppBlack,
                            style = AppTypography.L1,
                            textDecoration = TextDecoration.Underline

                        )
                    }
                }
            }
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
                    .constrainAs(imageRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(surfaceRef.top)
                    },
                painter = painterResource(R.drawable.teacher_image),
                contentDescription = stringResource(R.string.icon_teacher),
            )
        }
    }
}