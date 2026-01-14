package alex.dev.contourteacherapp.presentation.ui.componets.titles

import alex.dev.contourteacherapp.presentation.ui.theme.AccentTeacher
import alex.dev.contourteacherapp.presentation.ui.theme.AppBlack
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import alex.dev.contourteacherapp.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle

@Composable
fun AppTitle(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AppTypography.H1,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_title),
            style = textStyle,
            color = AppBlack
        )
        Text(
            text = "|",
            style = textStyle,
            color = AppBlack
        )
        Text(
            text = stringResource(R.string.app_subtitle),
            style = textStyle,
            color = AccentTeacher
        )
    }
}