package alex.dev.common.ui.components.buttons


import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.common.ui.theme.AppWhite
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        shape = AppShape.SHAPE_LARGE,
        border = BorderStroke(
            1.dp,
            AppWhite
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = AppWhite
        )
    ) {
        Text(
            text = label,
            style = AppTypography.L1
        )
    }
}

