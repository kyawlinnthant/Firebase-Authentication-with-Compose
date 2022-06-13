package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
fun LoginContent(
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

    onLoginClicked : ()->Unit,
    onPasswordClicked : ()->Unit,
    onSignupClicked : ()->Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ){
            InputTextField(
                modifier = modifier.fillMaxWidth(),
                inputText = emailValue,
                onValueChanged = onEmailChanged,
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
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClick = onPasswordClicked) {
                    Text(text = "Reset password")
                }
                Spacer(modifier = modifier.width(16.dp))
                Button(
                    onClick = onLoginClicked,
                    shape = RoundedCornerShape(size = 12.dp),
                    modifier = modifier
                        .height(56.dp)
                        .weight(0.5f)
                ) { Text(text = "Login") }
            }
            Spacer(modifier = modifier.height(24.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account?")
                Spacer(modifier = modifier.width(16.dp))
                TextButton(onClick = onSignupClicked) {
                    Text(text = "Signup")
                }
            }

        }


    }
}

@Preview
@Composable
private fun Preview() {
    Surface {
        LoginContent(
            emailValue = "",
            onEmailChanged = {},
            onEmailCleared = { },
            emailHint = "Fill Email",
            isEmailError = false,
            emailErrorMessage = "",
            passwordValue = "",
            onPasswordChanged = {},
            passwordHint = "Fill Password",
            isPasswordError = false,
            passwordErrorMessage = "",
            onLoginClicked = {  },
            onPasswordClicked = {},
            onSignupClicked = {}
        )
    }
}