package mdy.klt.firebaseauthenticationwithcompose.auth.common

import androidx.core.util.PatternsCompat

object FormValidator {
    fun isVerifiedEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isVerifiedPassword(password: String): Boolean {
        if (password.length < 8) {
            return false
        }
        if (password.length > 12) {
            return false
        }
        return true
    }

    fun isVerifiedConfirmPassword(
        confirmPassword: String,
    ): Boolean {
        if (confirmPassword.length < 8) {
            return false
        }
        if (confirmPassword.length > 12) {
            return false
        }
        return true
    }

    fun isIdenticalConfirmPassword(
        password: String,
        confirmPassword: String,
    ): Boolean {
        if (password != confirmPassword) {
            return false
        }
        return true
    }
}