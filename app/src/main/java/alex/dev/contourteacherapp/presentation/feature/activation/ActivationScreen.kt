package alex.dev.contourteacherapp.presentation.feature.activation

import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.layout.InviteCodeInputField
import alex.dev.contourteacherapp.presentation.ui.componets.titles.AppTitle
import alex.dev.contourteacherapp.presentation.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppLightGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import kotlinx.coroutines.delay

@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivationScreen(
    viewModel: ActivationViewModel = hiltViewModel(),
    onVerificationComplete: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    var enteredCode by remember { mutableStateOf("") }
    val configuration = LocalConfiguration.current

    LaunchedEffect(state) {
        if (state is ActivationState.Success) {
            delay(500)
            onVerificationComplete()
        }
    }
    Scaffold(
        containerColor = AppLightGray,
        topBar = {
            TopAppBar(
                title = {
                    AppTitle(
                        textStyle = AppTypography.H2,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppLightGray
                )
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .height(configuration.screenHeightDp.dp * 0.5f),
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
                ) {
                    Text(
                        text = stringResource(R.string.check_role_t),
                        style = AppTypography.H2,
                        color = AppBlack,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(AppSize.SIZE_SMALL))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.check_role_top_s),
                        color = AppGray,
                        textAlign = TextAlign.Center,
                        style = AppTypography.L1
                    )
                    InviteCodeInputField(
                        numberOfCharacters = 5,
                        isError = state is ActivationState.Error,
                        isLoading = state is ActivationState.Loading,
                        errorMessage = if (state is ActivationState.Error && enteredCode.length == 5)
                            (state as? ActivationState.Error)?.message else null,
                        successMessage = if (state is ActivationState.Success) stringResource(R.string.invite_code_success_m) else null,
                        onVerifyCode = { code ->
                            viewModel.verifyCode(code)
                        },
                        onCodeChange = { newCode ->
                            enteredCode = newCode
                            if (state is ActivationState.Error || state is ActivationState.Success) {
                                viewModel.resetState()
                            }
                        }
                    )
                }
            }
        }
    }
}

