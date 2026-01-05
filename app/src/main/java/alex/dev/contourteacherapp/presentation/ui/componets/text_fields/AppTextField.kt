package alex.dev.common.ui.components.text_fields

import alex.dev.common.ui.theme.AppBlack
import alex.dev.common.ui.theme.AppError
import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.common.ui.theme.AppShape
import alex.dev.common.ui.theme.AppSize
import alex.dev.common.ui.theme.AppSuccess
import alex.dev.common.ui.theme.AppTypography
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    enabled: Boolean = true,
    error: Boolean = false,
    isSuccess: Boolean = false,
    expanded: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxLines: Int = if (expanded) Int.MAX_VALUE else 1,
    minLines: Int = if (expanded) 2 else 1,
    textStyle: TextStyle = AppTypography.L1,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
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

    Column() {
        Text(text = label, style = AppTypography.L1, color = AppBlack)
        Spacer(modifier=Modifier.height(AppSize.SIZE_SMALL))
        TextField(
            modifier = modifier
                .fillMaxWidth()
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
            maxLines = maxLines,
            minLines = minLines,
            shape = AppShape.SHAPE_SMALL,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            textStyle = textStyle,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
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

