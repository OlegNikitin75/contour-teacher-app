package alex.dev.contourteacherapp.presentation.feature.intro

import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.buttons.PrimaryButton
import alex.dev.contourteacherapp.presentation.ui.componets.titles.AppTitle
import alex.dev.contourteacherapp.presentation.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppLightGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
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
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun IntroScreen(
    onNavigateToCheckRoleScreen: () -> Unit,
) {
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
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.intro_t),
                        style = AppTypography.H2,
                        color = AppBlack,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(AppSize.SIZE_LARGE))
                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AppSize.SIZE_EXTRA_LARGE),
                        onClick = onNavigateToCheckRoleScreen,
                        label = stringResource(R.string.verify_access_b),
                        containerColor = AppBlack,
                        contentColor = AppWhite
                    )
                }
            }
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(imageRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(surfaceRef.top)
                    },
                painter = painterResource(R.drawable.teacher_image),
                contentDescription = stringResource(R.string.teacher_image_d),
            )
        }
    }
}

