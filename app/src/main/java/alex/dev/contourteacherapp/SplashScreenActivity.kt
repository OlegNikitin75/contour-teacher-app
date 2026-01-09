package alex.dev.contourteacherapp

import alex.dev.contourteacherapp.presentation.ui.componets.layout.SplashScreen
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen(
                navigateToIntroScreen = {
                    val intent = Intent(this, TeacherMainActivity::class.java)
                    startActivity(intent)
                    finish()
                },
            )
        }
    }
}