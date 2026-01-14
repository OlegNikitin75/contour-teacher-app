package alex.dev.contourteacherapp.presentation.ui.componets.text_fields

import alex.dev.contourteacherapp.presentation.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppError
import alex.dev.contourteacherapp.presentation.ui.theme.AppGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppLightGray
import alex.dev.contourteacherapp.presentation.ui.theme.AppSuccess
import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    title: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    onVisibilityChange: (() -> Unit)? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    error: Boolean = false,
    isSuccess: Boolean = false,
    showPassword: Boolean? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: Boolean?=null,
    textStyle: TextStyle = AppTypography.L1,
    trailingIconId: Int? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val borderColor by animateColorAsState(
        targetValue = when {
            !enabled -> AppLightGray
            error -> AppError
            isSuccess -> AppSuccess
            isFocused -> AppBlack
            else -> Color.Transparent
        }
    )

    Column(modifier = modifier) {
        title?.let { Text(text = title, style = AppTypography.L1, color = AppBlack) }
        Spacer(modifier = Modifier.height(AppSize.SIZE_SMALL))
        TextField(
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = AppShape.SHAPE_SMALL
                ),
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            isError = error,
            placeholder = placeholder?.let {
                { Text(text = it, style = AppTypography.L1) }
            },
            singleLine = true,
            shape = AppShape.SHAPE_SMALL,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = if (visualTransformation == true && !showPassword!!) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },

            textStyle = textStyle,
            trailingIcon = {
                if (trailingIconId != null) {
                    Icon(
                        modifier = Modifier.clickable { if (onVisibilityChange != null) onVisibilityChange() },
                        painter = painterResource(id = trailingIconId),
                        contentDescription = null
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = AppLightGray,
                focusedContainerColor = AppLightGray,
                disabledContainerColor = AppLightGray,
                errorContainerColor = AppLightGray,
                unfocusedTextColor = AppGray,
                focusedTextColor = AppGray,
                disabledTextColor = AppGray.copy(alpha = 0.4f),
                errorTextColor = AppGray,
                unfocusedPlaceholderColor = AppGray,
                focusedPlaceholderColor = AppGray,
                disabledPlaceholderColor = AppGray.copy(alpha = 0.4f),
                errorPlaceholderColor = AppGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            )
        )
    }
}

