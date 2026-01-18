package alex.dev.contourteacherapp.presentation.navigation

import alex.dev.contourteacherapp.presentation.feature.activation.ActivationScreen
import alex.dev.contourteacherapp.presentation.feature.auth.sign_in_screen.SignInScreen
import alex.dev.contourteacherapp.presentation.feature.complete_profile.CompleteProfileScreen
import alex.dev.contourteacherapp.presentation.feature.intro.IntroScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun TeacherMainNavigationGraph(
    viewModel: AppStartupViewModel = hiltViewModel(),
    splashScreen: SplashScreen
) {
    val navController = rememberNavController()
    val startState by viewModel.startState.collectAsStateWithLifecycle()

    LaunchedEffect(startState) {
        if (startState != TeacherScreens.Loading) {
            delay(1000)
            splashScreen.setKeepOnScreenCondition { false }
        }
    }
    when (startState) {
        TeacherScreens.Loading -> {
            Box(Modifier.fillMaxSize())
        }

        else -> {
            NavHost(
                navController = navController,
                startDestination = startState,
                modifier = Modifier.fillMaxSize()
            ) {
                composable<TeacherScreens.IntroScreen> {
                    IntroScreen(
                        onNavigateToCheckRoleScreen = {
                            navController.navigate(TeacherScreens.ActivationScreen) {
                                popUpTo(navController.graph.id) { inclusive = true }
                            }
                        },
                    )
                }

                composable<TeacherScreens.ActivationScreen> {
                    ActivationScreen(
                        onVerificationComplete = {
                            navController.navigate(TeacherScreens.SignInScreen) {
                                popUpTo<TeacherScreens.ActivationScreen> { inclusive = true }
                            }
                        }
                    )
                }

                composable<TeacherScreens.SignInScreen> {
                    SignInScreen(
                        onLoginWithGoogleComplete = {
                            // После успешного логина сразу идем на заполнение профиля
                            navController.navigate(TeacherScreens.CompleteProfileScreen) {
                                popUpTo(0) { inclusive = true }
                            }
                        }
                    )
                }

                composable<TeacherScreens.CompleteProfileScreen> {
                    CompleteProfileScreen(
//                        onProfileSaved = {
//                            navController.navigate(AppStartState.Main) {
//                                popUpTo(0) { inclusive = true }
//                            }
//                        }
                    )
                }
                composable<TeacherScreens.HomeGraph> {
//                    MainScreen(
//                        // ваши аргументы, bottom bar и т.д.
//                    )
//                }
                }
            }
        }
    }
}