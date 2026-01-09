package alex.dev.contourteacherapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class TeacherScreens {
    @Serializable
    data object IntroScreen : TeacherScreens()

    @Serializable
    data object CheckRoleScreen : TeacherScreens()

    @Serializable
    data object SignInScreen : TeacherScreens()

    @Serializable
    data object SignUpScreen : TeacherScreens()

    @Serializable
    data object CompleteProfileScreen : TeacherScreens()

    @Serializable
    data object HomeGraph : TeacherScreens()
}