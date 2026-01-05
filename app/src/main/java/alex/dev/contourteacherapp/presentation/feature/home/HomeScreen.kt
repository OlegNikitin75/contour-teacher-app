package alex.dev.contourteacherapp.presentation.feature.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    navigateToSignIn: () -> Unit = {},
    navigateToProfile: () -> Unit = {}
) {
    Text(text = "Home Screen")
}