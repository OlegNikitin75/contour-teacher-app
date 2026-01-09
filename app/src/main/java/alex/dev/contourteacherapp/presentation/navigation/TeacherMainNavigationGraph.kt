package alex.dev.contourteacherapp.presentation.navigation

import alex.dev.contourteacherapp.presentation.feature.auth.sign_in_screen.SignInScreen
import alex.dev.contourteacherapp.presentation.feature.check_role.CheckRoleScreen
//import alex.dev.contourteacherapp.presentation.feature.auth.sign_up_screen.SignUpScreen
import alex.dev.contourteacherapp.presentation.feature.intro.IntroScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TeacherMainNavigationGraph(startDestination: TeacherScreens = TeacherScreens.IntroScreen) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<TeacherScreens.IntroScreen> {
            IntroScreen(
                onNavigateToCheckRoleScreen = {
                    navController.navigate(TeacherScreens.CheckRoleScreen)
                },
                onNavigateToSignIn = {
                    navController.navigate(TeacherScreens.SignInScreen)
                }
            )
        }
        composable<TeacherScreens.CheckRoleScreen> {
            CheckRoleScreen(
                onVerificationComplete = {
                    navController.navigate(TeacherScreens.SignUpScreen)
                },
                )
        }
//        composable<TeacherScreens.SignUpScreen> {
//            SignUpScreen(
//                onRegisterComplete = {
//                    navController.navigate(TeacherScreens.CompleteProfileScreen) {
//                        popUpTo(0) { inclusive = true }
//                    }
//                },
//                onNavigateToSignIn = {
//                    navController.navigate(TeacherScreens.SignInScreen)
//                },
//            )
//        }
//        composable<TeacherScreens.CompleteProfileScreen> {
//            TeacherScreens.CompleteProfileScreen(
//                onRegisterFull = {
//                    navController.navigate(TeacherScreens.HomeGraph) {
//                        popUpTo(0) { inclusive = true }
//                    }
//                },
//            )
//        }
        composable<TeacherScreens.SignInScreen> {
            SignInScreen(
                onLoginComplete = {
                    // При успешном входе удаляем ВСЕ экраны аутентификации
                    navController.navigate(TeacherScreens.HomeGraph) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                navigateToSignUp = {
                    // Просто переход на регистрацию
                    navController.navigate(TeacherScreens.SignUpScreen)
                },
                navigateToBack = {
                    // Возврат на IntroScreen (или другой предыдущий)
                    navController.popBackStack()
                }
            )
        }
//        composable<TeacherScreens.HomeGraph> {
//            HomeScreen(
//                navigateToSignIn = {
//                    navController.navigate(TeacherScreens.SignInScreen) {
//                        popUpTo<TeacherScreens.HomeGraph> { inclusive = true }
//                    }
//                },
////                navigateToProfile = {
////                    navController.navigate(TeacherScreens.ProfileScreen)
////                }
//            )
//        }
//        composable<TeacherScreens.ProfileScreen> {
//            ProfileScreen(
//                navigateBack = {
//                    navController.navigateUp()
//                })
//        }
    }
}