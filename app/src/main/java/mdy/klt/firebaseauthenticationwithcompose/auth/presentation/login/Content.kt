package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    inputText: String,
    onValueChanged: (text: String) -> Unit

) {
    Column(modifier = modifier.fillMaxSize()) {

        Text(text = "Connect your friends", style = MaterialTheme.typography.h2)

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ){
            InputTextField(
                modifier = modifier.fillMaxWidth(),
                inputText = "",
                onValueChanged = {

                },
                hint = "Fill Email",
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
            Spacer(modifier = modifier.height(16.dp))
            InputTextField(
                modifier = modifier.fillMaxWidth(),
                inputText = "",
                onValueChanged = {

                },
                hint = "Fill Password",
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
            Spacer(modifier = modifier.height(16.dp))
            Button(
                onClick = {},
                shape = RoundedCornerShape(size = 12.dp),
                modifier = modifier
                    .height(56.dp)
                    .fillMaxWidth(fraction = 0.4f)
            ) {
                Text(text = "Login")
            }
        }


    }
}

@Preview
@Composable
private fun Preview() {
    Surface {
        LoginContent(
            inputText = "",
            onValueChanged = {}
        )
    }
}