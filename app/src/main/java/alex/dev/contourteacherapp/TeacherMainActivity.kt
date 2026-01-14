package alex.dev.contourteacherapp

import alex.dev.contourteacherapp.presentation.ui.theme.AppWhite
import alex.dev.contourteacherapp.presentation.navigation.TeacherMainNavigationGraph
import alex.dev.contourteacherapp.ui.theme.ContourTeacherAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeacherMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.auto(
                AppWhite.toArgb(),
                AppWhite.toArgb()
            )
        )
        setContent {
            ContourTeacherAppTheme() {
                TeacherMainNavigationGraph()
            }
        }
    }
}


