package alex.dev.contourteacherapp

import alex.dev.contourteacherapp.presentation.ui.componets.layout.SplashScreen
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

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
                image= painterResource(R.drawable.teacher_icon_splash),
                contentDescription= stringResource(R.string.icon_teacher),
                subTitle= stringResource(R.string.app_sub_title)
            )
        }
    }
}