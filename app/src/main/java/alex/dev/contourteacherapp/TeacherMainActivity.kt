package alex.dev.contourteacherapp

import alex.dev.contourteacherapp.presentation.navigation.TeacherMainNavigationGraph
import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import alex.dev.contourteacherapp.ui.theme.ContourTeacherAppTheme
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeacherMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { true }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.auto(
                AppWhite.toArgb(),
                AppWhite.toArgb()
            )
        )
        setContent {
            ContourTeacherAppTheme() {
                TeacherMainNavigationGraph(
                    splashScreen = splashScreen
                )
            }
        }
    }
}


