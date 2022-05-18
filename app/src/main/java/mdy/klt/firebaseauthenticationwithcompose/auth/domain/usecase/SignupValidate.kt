package mdy.klt.firebaseauthenticationwithcompose.auth.domain.usecase

import mdy.klt.firebaseauthenticationwithcompose.auth.common.FormValidator
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupError
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupForm
import javax.inject.Inject

class SignupValidate @Inject constructor() {
    operator fun invoke(
        form: SignupForm
    ): SignupError {
        val isVerifiedEmail = FormValidator.isVerifiedEmail(email = form.email)
        val isVerifiedPassword = FormValidator.isVerifiedPassword(password = form.password)
        val isVerifiedConfirmPassword = FormValidator.isVerifiedConfirmPassword(
            password = form.password,
            confirmPassword = form.confirmPassword
        )
        return SignupError(
            emailError = !isVerifiedEmail,
            passwordError = !isVerifiedPassword,
            confirmPasswordError = !isVerifiedConfirmPassword
        )
    }
}