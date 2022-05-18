package mdy.klt.firebaseauthenticationwithcompose.auth.common


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FormValidatorTest {

    @Test
    fun `empty email - returns false`() {
        val result = FormValidator.isVerifiedEmail(email = "")
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrect email format - returns false`() {
        val result1 = FormValidator.isVerifiedEmail(email = "A123@.com")
        val result2 = FormValidator.isVerifiedEmail(email = "ABCD")
        val result3 = FormValidator.isVerifiedEmail(email = "A 12,3-@.com")
        assertThat(result1).isFalse()
        assertThat(result2).isFalse()
        assertThat(result3).isFalse()
    }

    @Test
    fun `correct email - returns true`() {
        val result = FormValidator.isVerifiedEmail(email = "kyawlinnthantkyawlinnthant@gmail.com")
        assertThat(result).isTrue()
    }

    @Test
    fun `empty password - returns false`() {
        val result = FormValidator.isVerifiedPassword(password = "")
        assertThat(result).isFalse()
    }

    @Test
    fun `password less than 8 - returns false`() {
        val result = FormValidator.isVerifiedPassword(password = "1234567")
        assertThat(result).isFalse()
    }

    @Test
    fun `password larger than 12 - returns false`() {
        val result = FormValidator.isVerifiedPassword(password = "1234567890123")
        assertThat(result).isFalse()
    }

    @Test
    fun `password not matches rules even it has length include between 8,12 - returns false`() {
        val result1 = FormValidator.isVerifiedPassword(password = "12345678")
        val result2 = FormValidator.isVerifiedPassword(password = "abcdefgh")
        val result3 = FormValidator.isVerifiedPassword(password = "ABCDEFGH")
        val result4 = FormValidator.isVerifiedPassword(password = "@!#$%^&*")
        val result5 = FormValidator.isVerifiedPassword(password = "Aa 12345!")
        val result6 = FormValidator.isVerifiedPassword(password = "Apple12345")
        assertThat(result1).isFalse()
        assertThat(result2).isFalse()
        assertThat(result3).isFalse()
        assertThat(result4).isFalse()
        assertThat(result5).isFalse()
        assertThat(result6).isFalse()
    }

    @Test
    fun `password include between 8,12 and matches with our rules - returns true`() {
        val result1 = FormValidator.isVerifiedPassword(password = "!Apple12345")
        val result2 = FormValidator.isVerifiedPassword(password = "#Apple12345")
        val result3 = FormValidator.isVerifiedPassword(password = "\$Apple12345")
        val result4 = FormValidator.isVerifiedPassword(password = "%Apple12345")
        val result5 = FormValidator.isVerifiedPassword(password = "^Apple12345")
        val result6 = FormValidator.isVerifiedPassword(password = "&Apple12345")
        val result7 = FormValidator.isVerifiedPassword(password = "+Apple12345")
        val result8 = FormValidator.isVerifiedPassword(password = "-Apple12345")

        assertThat(result1).isTrue()
        assertThat(result2).isTrue()
        assertThat(result3).isTrue()
        assertThat(result4).isTrue()
        assertThat(result5).isTrue()
        assertThat(result6).isTrue()
        assertThat(result7).isTrue()
        assertThat(result8).isTrue()
    }


    @Test
    fun `confirm password not identical with password - returns false`() {
        val result = FormValidator.isVerifiedConfirmPassword(
            password = "!Apple12345",
            confirmPassword = "12345678910"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is in rules and confirm-password identical to password - returns true`() {
        val result = FormValidator.isVerifiedConfirmPassword(
            password = "!Apple12345",
            confirmPassword = "!Apple12345"
        )
        assertThat(result).isTrue()
    }

}