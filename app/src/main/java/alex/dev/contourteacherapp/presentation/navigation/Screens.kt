package alex.dev.contourteacherapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class TeacherScreens {

    @Serializable
    data object Loading : TeacherScreens()

    @Serializable
    data object IntroScreen : TeacherScreens()

    @Serializable
    data object ActivationScreen : TeacherScreens()

    @Serializable
    data object SignInScreen : TeacherScreens()

    @Serializable
    data object SuccessSignInScreen : TeacherScreens()

    @Serializable
    data object SuccessCompleteProfileScreen : TeacherScreens()


    @Serializable
    data object CompleteProfileScreen : TeacherScreens()

    @Serializable
    data object HomeGraph : TeacherScreens()
}