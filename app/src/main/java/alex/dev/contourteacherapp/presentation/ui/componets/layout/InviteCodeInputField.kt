package alex.dev.contourteacherapp.presentation.ui.componets.layout

import alex.dev.common.ui.theme.AppError
import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.common.ui.theme.AppSuccess
import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.buttons.PrimaryButton
import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InviteCodeInputField(
    modifier: Modifier = Modifier,
    numberOfCharacters: Int = 5,
    isError: Boolean = false,
    isLoading: Boolean = false,
    errorMessage: String? = null,
    successMessage: String? = null,
    onCodeChange: (String) -> Unit = {},
    onVerifyCode: (String) -> Unit = {},
) {
    val code = rememberTextFieldState()
    val focusRequester = remember { FocusRequester() }


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    LaunchedEffect(code.text) {
        onCodeChange(code.text.toString())
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BasicTextField(
            state = code,
            modifier = Modifier
                .focusRequester(focusRequester)
                .semantics {
                    contentType = ContentType.SmsOtpCode
                },
            inputTransformation = InputTransformation.maxLength(numberOfCharacters),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            ),
            onKeyboardAction = {
                if (code.text.length == numberOfCharacters) {
                    onVerifyCode(code.text.toString())
                }
            },
            lineLimits = TextFieldLineLimits.SingleLine,
            decorator = {
                val otpCode = code.text.toString()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppSize.SIZE_NORMAL),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(numberOfCharacters) { index ->
                        Cell(
                            char = otpCode.getOrElse(index) { ' ' },
                            highlight = index == code.text.length,
                            error = isError
                        )
                    }
                }
            }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            when {
                isLoading -> {}
                isError && !errorMessage.isNullOrBlank() -> {
                    Text(
                        text = errorMessage,
                        color = AppError,
                        style = AppTypography.T1,
                        textAlign = TextAlign.Center
                    )
                }

                !successMessage.isNullOrBlank() -> {
                    Text(
                        text = successMessage,
                        color = AppSuccess,
                        style = AppTypography.T1,
                        textAlign = TextAlign.Center
                    )
                }

                else -> {}
            }
        }
        Spacer(modifier = Modifier.height(AppSize.SIZE_MEDIUM))
        PrimaryButton(
            label = if (isLoading) "" else stringResource(R.string.check_code_b),
            onClick = { onVerifyCode(code.text.toString()) },
            isEnabled = code.text.length == numberOfCharacters && !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(AppSize.SIZE_EXTRA_LARGE),
            isLoading = isLoading
        )
    }
}

@Composable
private fun Cell(
    char: Char,
    highlight: Boolean,
    error: Boolean
) {
    val borderSize by animateDpAsState(
        targetValue = when {
            error || highlight -> 2.dp
            else -> 0.dp
        }
    )
    val borderColor by animateColorAsState(
        targetValue = when {
            error -> AppError
            else -> AppGray
        }
    )

    Box(
        modifier = Modifier
            .padding(horizontal = AppSize.SIZE_EXTRA_SMALL)
            .width(AppSize.SIZE_LARGE)
            .height(AppSize.SIZE_EXTRA_EXTRA_LARGE)
            .clip(shape = AppShape.SHAPE_EXTRA_LARGE)
            .background(AppLightGray)
            .border(borderSize, borderColor, AppShape.SHAPE_EXTRA_LARGE),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = char.toString(),
            style = AppTypography.H3,
            color = AppGray
        )
    }
}

