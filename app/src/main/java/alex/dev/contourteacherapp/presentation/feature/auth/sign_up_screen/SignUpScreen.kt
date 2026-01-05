package alex.dev.contour.teacher.ui.screens.auth.sign_up_screen

import alex.dev.common.ui.components.buttons.PrimaryButton
import alex.dev.common.ui.components.text_fields.AppTextField
import alex.dev.common.ui.components.titles.AppTitle
import alex.dev.common.ui.theme.AppBlack
import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.common.ui.theme.AppSize
import alex.dev.common.ui.theme.AppTypography
import alex.dev.common.ui.theme.AppWhite
import alex.dev.common.ui.theme.Resources
import alex.dev.contour.teacher.R
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(
    onRegisterComplete: () -> Unit,
    onNavigateToSignIn: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppLightGray,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTitle(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp),
                appSubTitle = stringResource(R.string.app_sub_title),
                textStyle = AppTypography.H2,
            )

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
                        text = stringResource(Resources.Strings.TitleSignupScreen),
                        style = AppTypography.H2,
                        color = AppBlack,
                        textAlign = TextAlign.Center,
                    )
                    Column() {
                        AppTextField(
                            label = stringResource(Resources.LabelsTextFields.Email),
                            value = "jj",
                            onValueChange = {},
                            placeholder = "hello@contour.com",
                            error = false,
                            isSuccess = false,
                            maxLines = 1,
                        )
                    }

                    PrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(AppSize.SIZE_EXTRA_LARGE),
                        onClick = onRegisterComplete,
                        label = stringResource(Resources.LabelsOnButtons.SignUp),
                        containerColor = AppBlack,
                        contentColor = AppWhite
                    )
                    Row() {
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
                            style = AppTypography.L1
                        )
                    }
                }
            }
        }
    }
}

