package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.components.InputTextField
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.components.PasswordTextField

@Composable
fun SignupContent(
    modifier: Modifier = Modifier,

    emailValue: String,
    onEmailChanged: (String) -> Unit,
    onEmailCleared: () -> Unit,
    emailHint: String,
    isEmailError: Boolean,
    emailErrorMessage: String,

    passwordValue: String,
    onPasswordChanged: (String) -> Unit,
    passwordHint: String,
    isPasswordError: Boolean,
    passwordErrorMessage: String,

    confirmPasswordValue: String,
    onConfirmPasswordChanged: (String) -> Unit,
    confirmPasswordHint: String,
    isConfirmPasswordError: Boolean,
    confirmPasswordErrorMessage: String,

    onSignupClicked: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            InputTextField(
                modifier = modifier.fillMaxWidth(),
                inputText = emailValue,
                onValueChanged = { onEmailChanged(it) },
                onValueCleared = onEmailCleared,
                hint = emailHint,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                isError = isEmailError,
                errorMessage = emailErrorMessage,
            )
            Spacer(modifier = modifier.height(16.dp))
            PasswordTextField(
                modifier = modifier.fillMaxWidth(),
                inputText = passwordValue,
                onValueChanged = { onPasswordChanged(it) },
                hint = passwordHint,
                isError = isPasswordError,
                errorMessage = passwordErrorMessage
            )
            Spacer(modifier = modifier.height(16.dp))
            PasswordTextField(
                modifier = modifier.fillMaxWidth(),
                inputText = confirmPasswordValue,
                onValueChanged = { onConfirmPasswordChanged(it) },
                hint = confirmPasswordHint,
                isError = isConfirmPasswordError,
                errorMessage = confirmPasswordErrorMessage
            )
            Spacer(modifier = modifier.height(16.dp))
            Button(
                onClick = { onSignupClicked() },
                shape = RoundedCornerShape(size = 12.dp),
                modifier = modifier
                    .height(48.dp)
                    .fillMaxWidth(fraction = 0.4f)
            ) {
                Text(text = "Register")
            }
        }
    }
}

@Composable
@Preview
private fun DefaultPreview() {
    Surface {
        SignupContent(
            emailValue = "",
            onEmailChanged = { },
            onEmailCleared = { },
            emailHint = "Fill your email",
            isEmailError = false,
            emailErrorMessage = "",
            passwordValue = "",
            onPasswordChanged = {},
            passwordHint = "Fill your password",
            isPasswordError = false,
            passwordErrorMessage = "",
            confirmPasswordValue = "",
            onConfirmPasswordChanged = {},
            confirmPasswordHint = "Confirm password again",
            isConfirmPasswordError = false,
            confirmPasswordErrorMessage = "",
            onSignupClicked = {}
        )
    }
}
@Composable
@Preview
private fun ValuePreview() {
    Surface {
        SignupContent(
            emailValue = "klt@gmail.com",
            onEmailChanged = { },
            onEmailCleared = { },
            emailHint = "",
            isEmailError = false,
            emailErrorMessage = "",
            passwordValue = "!Apple12345",
            onPasswordChanged = {},
            passwordHint = "",
            isPasswordError = false,
            passwordErrorMessage = "",
            confirmPasswordValue = "!Apple12345",
            onConfirmPasswordChanged = {},
            confirmPasswordHint = "Confirm password again",
            isConfirmPasswordError = false,
            confirmPasswordErrorMessage = "",
            onSignupClicked = {}
        )
    }
}
@Composable
@Preview
private fun ErrorPreview() {
    Surface {
        SignupContent(
            emailValue = "klt!@gmail.com",
            onEmailChanged = { },
            onEmailCleared = { },
            emailHint = "",
            isEmailError = true,
            emailErrorMessage = "Correct your email",
            passwordValue = "!Apple12345",
            onPasswordChanged = {},
            passwordHint = "",
            isPasswordError = true,
            passwordErrorMessage = "Password must have at least 8 and not exceed 12 characters",
            confirmPasswordValue = "!Apple12345",
            onConfirmPasswordChanged = {},
            confirmPasswordHint = "",
            isConfirmPasswordError = true,
            confirmPasswordErrorMessage = "Confirm password must be the same with password",
            onSignupClicked = {}
        )
    }
}