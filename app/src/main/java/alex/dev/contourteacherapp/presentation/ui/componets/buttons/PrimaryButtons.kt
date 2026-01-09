package alex.dev.contourteacherapp.presentation.ui.componets.buttons

import alex.dev.common.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.common.ui.theme.AppWhite
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick:() -> Unit,
    isLoading: Boolean = false,
    isEnabled: Boolean = true,
    contentColor: Color = AppWhite,
    containerColor: Color = AppBlack,
    disabledContainerColor: Color = Color.Gray,
    disabledContentColor: Color = Color.LightGray
) {
    Button(
        onClick = onClick,
        enabled = isEnabled && !isLoading,
        modifier = modifier,
        shape = AppShape.SHAPE_LARGE,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isEnabled && !isLoading) containerColor else disabledContainerColor,
            contentColor = if (isEnabled && !isLoading) contentColor else disabledContentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp,
                color = LocalContentColor.current
            )
        } else {
            Text(
                text = label,
                style = AppTypography.L1
            )
        }
    }
}



