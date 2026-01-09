package alex.dev.contourteacherapp.presentation.ui.componets.layout

import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.buttons.PrimaryButton
import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OtpInputField(
    modifier: Modifier = Modifier,
    numberOfCharacters: Int,
    verifyCode: (String) -> Unit,
) {
    val code = rememberTextFieldState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        BasicTextField(
            state = code,
            modifier = Modifier.semantics {
                contentType = ContentType.SmsOtpCode
            },
            inputTransformation = InputTransformation.maxLength(numberOfCharacters),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            lineLimits = TextFieldLineLimits.SingleLine,
            decorator = {
                val otpCode = code.text.toString()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(numberOfCharacters) { index ->
                        Cell(
                            char = otpCode.getOrElse(index) { ' ' },
                            highlight = index == code.text.length
                        )
                    }
                }
            }
        )
        // Удалите эту строку, если она заглушка: Text(text = "text")
        Spacer(modifier = Modifier.height(AppSize.SIZE_MEDIUM))
        PrimaryButton(
            label = stringResource(R.string.check_code_b),
            onClick = { verifyCode(code.text.toString()) },
            isEnabled = code.text.length == numberOfCharacters,
            modifier = Modifier
                .fillMaxWidth()
                .height(AppSize.SIZE_EXTRA_LARGE)
        )
    }
}

@Composable
private fun Cell(
    char: Char,
    highlight: Boolean
) {
    val borderSize by animateDpAsState(
        targetValue = if (highlight) 2.dp else 0.dp
    )

    Box(
        modifier = Modifier
            .padding(horizontal = AppSize.SIZE_EXTRA_SMALL)
            .width(AppSize.SIZE_LARGE)
            .height(AppSize.SIZE_EXTRA_EXTRA_LARGE)
            .clip(shape = AppShape.SHAPE_EXTRA_LARGE)
            .background(AppLightGray)
            .border(borderSize, AppGray, AppShape.SHAPE_EXTRA_LARGE),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = char.toString(),
            style = AppTypography.H3,
            color = AppGray
        )
    }
}

