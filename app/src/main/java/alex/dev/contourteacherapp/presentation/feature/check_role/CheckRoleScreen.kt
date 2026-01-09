package alex.dev.contourteacherapp.presentation.feature.check_role

import alex.dev.common.ui.theme.AppBlack
import alex.dev.common.ui.theme.AppGray
import alex.dev.common.ui.theme.AppLightGray
import alex.dev.common.ui.theme.AppWhite
import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.presentation.ui.componets.layout.OtpInputField
import alex.dev.contourteacherapp.presentation.ui.componets.titles.AppTitle
import alex.dev.contourteacherapp.presentation.ui.theme.AppSize
import alex.dev.contourteacherapp.presentation.ui.theme.AppTypography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CheckRoleScreen(
    onVerificationComplete: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = AppLightGray,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTitle(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp),
                textStyle = AppTypography.H2,
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                color = AppWhite,
                shape = RoundedCornerShape(
                    topStart = AppSize.SIZE_MEDIUM,
                    topEnd = AppSize.SIZE_MEDIUM
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = AppSize.SIZE_MEDIUM,
                            bottom = AppSize.SIZE_MEDIUM,
                            start = AppSize.SIZE_NORMAL,
                            end = AppSize.SIZE_NORMAL
                        )
                        .imePadding(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.check_role_t),
                        style = AppTypography.H2,
                        color = AppBlack,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(AppSize.SIZE_SMALL))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.check_role_top_s),
                        color = AppGray,
                        textAlign = TextAlign.Center,
                        style = AppTypography.L1
                    )
                    OtpInputField(
                        modifier = Modifier.padding(vertical = AppSize.SIZE_MEDIUM),
                        numberOfCharacters = 5,
                        verifyCode = { TODO() }
                    )
                }
            }
        }
    }
}

