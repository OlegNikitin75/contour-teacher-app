package alex.dev.contourteacherapp.presentation.ui.componets

import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.theme.AppShape
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppSuccess
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun AppSnackBar(
    modifier: Modifier = Modifier,
    iconId: Int = R.drawable.ic_success,
    message: SnackbarData,
    containerColor: Color = AppSuccess,
) {
    Snackbar() {
        Box(modifier.padding(AppSize.SIZE_NORMAL)) {
            Row(
                modifier = modifier
                    .clip(shape = AppShape.SHAPE_SMALL)
                    .background(containerColor)
                    .padding(AppSize.SIZE_NORMAL),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(iconId),
                    contentDescription = null,
                    tint = AppWhite
                )
                Spacer(modifier = Modifier.width(AppSize.SIZE_SMALL))
                Text(
                    text = message.visuals.message,
                    style = AppTypography.T2,
                    color = AppWhite,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


