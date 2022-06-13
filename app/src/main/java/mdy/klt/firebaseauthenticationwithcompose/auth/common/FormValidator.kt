package mdy.klt.firebaseauthenticationwithcompose.auth.common

import androidx.core.util.PatternsCompat
import java.util.regex.Pattern

object FormValidator {
    fun isVerifiedEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email.trim()).matches()
    }

    /**

    ^                 # start-of-string
    (?=.*[0-9])       # a digit must occur at least once
    (?=.*[a-z])       # a lower case letter must occur at least once
    (?=.*[A-Z])       # an upper case letter must occur at least once
    (?=.*[!@#$%^&+-])  # a special character must occur at least once !@#$%^&+-
    (?=\\S+$)          # no whitespace allowed in the entire string
    .{4,}             # anything, at least six places though
    $                 # end-of-string

     */

    fun isVerifiedPassword(password: String): Boolean {
        if (password.length < 8) {
            return false
        }
        if (password.length > 12) {
            return false
        }

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+-])(?=\\S+$).{4,}$"
        val isMatched = Pattern.compile(passwordPattern).matcher(password)
        if (!isMatched.matches()) {
            return false
        }
        return true
    }

    fun isVerifiedConfirmPassword(
        password: String,
        confirmPassword: String,
    ): Boolean {
        if (confirmPassword.isEmpty()) return false
        if (password != confirmPassword) return false
        return true
    }
}