package alex.dev.common.ui.components.titles

import alex.dev.common.ui.theme.AccentTeacher
import alex.dev.common.ui.theme.AppBlack
import alex.dev.common.ui.theme.AppTypography
import alex.dev.common.ui.theme.Resources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle

@Composable
fun AppTitle(
    modifier: Modifier = Modifier,
    appTitle: Int = Resources.Strings.AppTitle,
    appSubTitle: String,
    textStyle: TextStyle = AppTypography.H1,
    baseColor: Color = AppBlack,
    accentColor: Color = AccentTeacher
) {
    Row(
        modifier=Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(appTitle),
            style = textStyle,
            color = baseColor
        )
        Text(
            text = "|",
            style = textStyle,
            color = baseColor
        )
        Text(
            text = appSubTitle,
            style = textStyle,
            color = accentColor
        )
    }
}