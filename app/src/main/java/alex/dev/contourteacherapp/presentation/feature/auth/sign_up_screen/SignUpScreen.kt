//package alex.dev.contourteacherapp.presentation.feature.auth.sign_up_screen
//
//import alex.dev.common.ui.theme.AppBlack
//import alex.dev.common.ui.theme.AppGray
//import alex.dev.common.ui.theme.AppLightGray
//import alex.dev.common.ui.theme.AppWhite
//import alex.dev.contourteacherapp.R
//import alex.dev.contourteacherapp.presentation.ui.componets.buttons.PrimaryButton
//import alex.dev.contourteacherapp.presentation.ui.componets.text_fields.AppTextField
//import alex.dev.contourteacherapp.presentation.ui.componets.titles.AppTitle
//import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
//import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
//
//@Composable
//fun SignUpScreen(
//    onRegisterComplete: () -> Unit,
//    onNavigateToSignIn: () -> Unit,
//    viewModel: AuthViewModel = hiltViewModel()
//
//) {
//    val email by viewModel.email.collectAsState()
//    val password by viewModel.password.collectAsState()
//    val confirmPassword by viewModel.confirmPassword.collectAsState()
//    val showPassword by viewModel.showPassword.collectAsState()
//    val showConfirmPassword by viewModel.showConfirmPassword.collectAsState()
//
//    val isLoading by viewModel.isLoading.collectAsState()
//
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        containerColor = AppLightGray,
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues),
//            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            AppTitle(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 56.dp),
//                textStyle = AppTypography.H2
//            )
//
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                color = AppWhite,
//                shape = RoundedCornerShape(
//                    topStart = AppSize.SIZE_MEDIUM,
//                    topEnd = AppSize.SIZE_MEDIUM
//                )
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(
//                            top = AppSize.SIZE_MEDIUM,
//                            bottom = AppSize.SIZE_MEDIUM,
//                            start = AppSize.SIZE_NORMAL,
//                            end = AppSize.SIZE_NORMAL
//                        ),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.spacedBy(AppSize.SIZE_MEDIUM)
//                ) {
//                    Column() {
//                        AppTextField(
//                            title = stringResource(R.string.email_l_tf),
//                            value = "jj",
//                            onValueChange = {},
//                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                            placeholder = stringResource(R.string.email_p_tf),
//                            error = false,
//                            isSuccess = false,
//                        )
//                        AppTextField(
//                            title = stringResource(R.string.password_l_tf),
//                            value = "jj",
//                            onValueChange = {},
//                            visualTransformation = true,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = KeyboardType.Password
//                            ),
//                            showPassword = showPassword,
//                            placeholder = stringResource(R.string.password_p_tf),
//                            trailingIconId = if (showPassword) {
//                                painterResource(R.drawable.ic_eye_shown)
//                            } else {
//                                painterResource(R.drawable.ic_eye_shown)
//                            },
//                            error = false,
//                            isSuccess = false,
//                        )
//                        AppTextField(
//                            title = stringResource(R.string.confirm_password_l_tf),
//                            value = "jj",
//                            onValueChange = {},
//                            visualTransformation = true,
//                            keyboardOptions = KeyboardOptions(
//                                keyboardType = KeyboardType.Password
//                            ),
//                            showPassword = showConfirmPassword,
//                            placeholder = stringResource(R.string.confirm_password_p_tf),
//                            trailingIconId = if (showConfirmPassword) {
//                                painterResource(R.drawable.ic_eye_shown)
//                            } else {
//                                painterResource(R.drawable.ic_eye_shown)
//                            },
//                            error = false,
//                            isSuccess = false,
//                        )
//                    }
//
//                    PrimaryButton(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(AppSize.SIZE_EXTRA_LARGE),
//                        onClick = onRegisterComplete,
//                        label = stringResource(R.string.signup_b),
//                        containerColor = AppBlack,
//                        contentColor = AppWhite
//                    )
//                    Row() {
//                        Text(
//                            modifier = Modifier.clickable { onNavigateToSignIn() },
//                            text = stringResource(R.string.intro_auth_s),
//                            color = AppGray,
//                            style = AppTypography.L1
//                        )
//                        Spacer(modifier = Modifier.width(AppSize.SIZE_SMALL))
//                        Text(
//                            modifier = Modifier.clickable { onNavigateToSignIn() },
//                            text = stringResource(R.string.signin_b),
//                            color = AppBlack,
//                            style = AppTypography.L1
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
