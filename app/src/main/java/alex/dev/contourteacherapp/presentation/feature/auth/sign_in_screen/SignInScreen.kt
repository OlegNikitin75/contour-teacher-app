package alex.dev.contourteacherapp.presentation.feature.auth.sign_in_screen

import androidx.compose.runtime.Composable

@Composable
fun SignInScreen(
    onLoginComplete: @Composable () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToBack: () -> Unit,

) {
//    val email by viewModel.email.collectAsState()
//    val password by viewModel.password.collectAsState()
//    var showPassword by remember { mutableStateOf(false) }
//    val isLoading by viewModel.isLoading.collectAsState()
//    val viewModel: AuthViewModel = hiltViewModel()
//
//    AppBox(
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = AppTheme.size.medium)
//                .padding(bottom = AppTheme.size.screenVerticalPadding),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            GhostButton(
//                iconId = R.drawable.ic_arrow_left_lm,
//                label = R.string.button_back_text,
//                onClick = onBackClick,
//            )
//            Column(
//                modifier = Modifier
//                    .padding(vertical = AppTheme.size.screenVerticalPadding)
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    modifier = Modifier
//                        .padding(bottom = AppTheme.size.medium)
//                        .size(AppTheme.size.screenIconSize),
//                    painter = painterResource(
//                        R.drawable.ic_lock_lm
//                    ),
//                    tint = AppTheme.colorScheme.primary,
//                    contentDescription = null
//                )
//                Text(
//                    text = stringResource(R.string.title_login_screen),
//                    style = AppTheme.typography.title,
//                    color = AppTheme.colorScheme.onBackgroundSecondary
//                )
//            }
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(rememberScrollState()),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Column() {
//                    AppTextField(
//                        value = email,
//                        onValueChange = viewModel::onEmailChanged,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                        label = stringResource(R.string.label_email),
//                        leadingIconId = R.drawable.ic_mail_lm,
//                    )
//                    Spacer(modifier = Modifier.height(AppTheme.size.normal))
//                    AppTextField(
//                        value = password,
//                        onValueChange = viewModel::onPasswordChanged,
//                        onVisibilityChange = { showPassword = !showPassword },
//                        showPassword = showPassword,
//                        passwordVisualTransformation = true,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                        label = stringResource(R.string.label_login_password),
//                        leadingIconId = R.drawable.ic_lock_lm,
//                        trailingIconId =
//                            if (showPassword) {
//                                R.drawable.ic_password_show_lm
//                            } else {
//                                R.drawable.ic_password_hidden_lm
//                            }
//                    )
//                }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    PrimaryButton(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(AppTheme.size.buttonHeightLarge),
//                        label = stringResource(R.string.button_login_text),
//                        isLoading = isLoading,
//                        isEnabled = !isLoading,
//                        onClick = {
//                            viewModel.signIn(email, password)
//                            onLoginComplete
//                        }
//                    )
//                    Spacer(modifier = Modifier.height(AppTheme.size.large))
//                    Row() {
//                        Text(
//                            text = stringResource(R.string.other_text_login_screen),
//                            style = AppTheme.typography.text,
//                            color = AppTheme.colorScheme.onBackgroundPrimary
//                        )
//                        Text(
//                            text = stringResource(R.string.link_to_register_text),
//                            color = AppTheme.colorScheme.primary,
//                            style = AppTheme.typography.label,
//                            modifier = Modifier
//                                .padding(start = AppTheme.size.small)
//                                .clickable {
//                                    onSignUpClick()
//                                }
//                        )
//                    }
//                }
//            }
//        }
//    }
}