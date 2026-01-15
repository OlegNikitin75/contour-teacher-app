package alex.dev.contourteacherapp.presentation.feature.auth.sign_in_screen

import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.buttons.PrimaryButton
import alex.dev.contourteacherapp.presentation.ui.componets.titles.AppTitle
import alex.dev.contourteacherapp.presentation.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppLightGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onLoginWithGoogleComplete: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppLightGray,
        topBar = {
            TopAppBar(
                title = {
                    AppTitle(
                        textStyle = AppTypography.H3,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppLightGray
                )
            )
        }
    )
    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .background(AppLightGray)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(R.drawable.teacher_image_signin),
                    contentDescription = stringResource(R.string.teacher_image_d),
                )
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
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
                        text = stringResource(R.string.signin_t),
                        style = AppTypography.H2,
                        color = AppBlack,
                        textAlign = TextAlign.Center
                    )
                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AppSize.SIZE_EXTRA_LARGE),
                        onClick = {},
                        label = stringResource(R.string.signin_b),
                        containerColor = AppBlack,
                        contentColor = AppWhite,
                        iconResId = R.drawable.ic_google_brands_white
                    )
                }
            }
        }
    }
}
