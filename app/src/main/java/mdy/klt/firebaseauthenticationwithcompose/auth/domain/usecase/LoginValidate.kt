package mdy.klt.firebaseauthenticationwithcompose.auth.domain.usecase

import mdy.klt.firebaseauthenticationwithcompose.auth.common.FormValidator
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginError
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginForm
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupError
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupForm
import javax.inject.Inject

class LoginValidate @Inject constructor() {
    operator fun invoke(form: LoginForm): LoginError {
        val isVerifiedEmail = FormValidator.isVerifiedEmail(email = form.email)
        val isVerifiedPassword = FormValidator.isVerifiedPassword(password = form.password)
        return LoginError(
            emailError = !isVerifiedEmail,
            passwordError = !isVerifiedPassword,
        )
    }
}