package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf

sealed class LoginAction {
    object ClickLogin : LoginAction()
    object ClickPassword : LoginAction()
    object ClickSignup : LoginAction()

    data class ChangeEmail(val email: String) : LoginAction()
    data class ChangePassword(val password: String) : LoginAction()
}
