package alex.dev.contourteacherapp.presentation.ui.componets.buttons

import alex.dev.contourteacherapp.presentation.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    isEnabled: Boolean = true,
    contentColor: Color = AppWhite,
    iconResId: Int? = null,
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                iconResId?.let {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(iconResId),
                        contentDescription = "button logo",
                    )
                    Spacer(modifier = Modifier.width(AppSize.SIZE_SMALL))
                }
                Text(
                    text = label,
                    style = AppTypography.L1,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



