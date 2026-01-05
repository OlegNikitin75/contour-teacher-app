package alex.dev.contourteacherapp

import alex.dev.contour.teacher.navigation.TeacherMainNavigationGraph
import alex.dev.contourteacherapp.ui.theme.ContourTeacherAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeacherMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContourTeacherAppTheme() {
                TeacherMainNavigationGraph()
            }
        }
    }
}


