package mdy.klt.firebaseauthenticationwithcompose.auth.common


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FormValidatorTest {

    @Test
    fun `empty email returns false`() {
        val result = FormValidator.isVerifiedEmail(email = "")
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrect email format returns false`() {
        val result1 = FormValidator.isVerifiedEmail(email = "A123@.com")
        val result2 = FormValidator.isVerifiedEmail(email = "ABCD")
        val result3 = FormValidator.isVerifiedEmail(email = "A 12,3-@.com")
        assertThat(result1).isFalse()
        assertThat(result2).isFalse()
        assertThat(result3).isFalse()
    }

    @Test
    fun `correct email returns true`() {
        val result = FormValidator.isVerifiedEmail(email = "kyawlinnthantkyawlinnthant@gmail.com")
        assertThat(result).isTrue()
    }

    @Test
    fun `empty password returns false`() {
        val result = FormValidator.isVerifiedPassword(password = "")
        assertThat(result).isFalse()
    }

    @Test
    fun `password less than 8 returns false`() {
        val result = FormValidator.isVerifiedPassword(password = "1234567")
        assertThat(result).isFalse()
    }

    @Test
    fun `password larger than 12 returns false`() {
        val result = FormValidator.isVerifiedPassword(password = "1234567890123")
        assertThat(result).isFalse()
    }

    @Test
    fun `password between 8 and 12 returns true`() {
        val result = FormValidator.isVerifiedPassword(password = "1234567890")
        assertThat(result).isTrue()
    }

    @Test
    fun `empty confirm password returns false`() {
        val result = FormValidator.isVerifiedConfirmPassword(confirmPassword = "")
        assertThat(result).isFalse()
    }

    @Test
    fun `confirm password larger than 12 returns false`() {
        val result = FormValidator.isVerifiedConfirmPassword(confirmPassword = "1234567890123")
        assertThat(result).isFalse()
    }

    @Test
    fun `confirm password between 8 and 12 returns true`() {
        val result = FormValidator.isVerifiedConfirmPassword(confirmPassword = "1234567890")
        assertThat(result).isTrue()
    }

    @Test
    fun `confirm password not same with password returns false`() {
        val result = FormValidator.isIdenticalConfirmPassword(
            password = "12345678",
            confirmPassword = "123456789"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password and confirm-password identical returns true`() {
        val result = FormValidator.isIdenticalConfirmPassword(
            password = "12345678",
            confirmPassword = "12345678"
        )
        assertThat(result).isTrue()
    }

}