package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mdy.klt.firebaseauthenticationwithcompose.R

@Composable
fun PasswordTextField(
    modifier: Modifier,
    inputText: String,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    singleLine: Boolean = true,
    borderShape: Shape = RoundedCornerShape(12.dp),
    hint: String,
    isError: Boolean,
    errorMessage: String,
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    val visibilityIcon =
        if (passwordVisibility) painterResource(id = R.drawable.ic_visibility_off)
        else painterResource(id = R.drawable.ic_visibility_on)


    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(borderShape)
                .border(
                    width = 1.dp,
                    color = if (isError) MaterialTheme.colors.error else
                        MaterialTheme.colors.onSurface.copy(0.7f),
                    shape = borderShape
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(all = 16.dp)
                    .weight(1f),
                value = inputText,
                onValueChange = onValueChanged,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                singleLine = singleLine,
                decorationBox = {
                    if (inputText.isEmpty()) {
                        Text(
                            text = hint,
                            color = MaterialTheme.colors.onSurface.copy(0.7f),
                        )
                    }
                    it()
                },
                cursorBrush = SolidColor(
                    value = MaterialTheme.colors.primary
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            )

            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = visibilityIcon,
                    contentDescription = "Close Text",
                    tint = MaterialTheme.colors.onSurface.copy(0.5f)

                )
            }

        }
        VisibilityAnimator(isVisible = isError, errorMessage = errorMessage)
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    Surface {
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "",
            onValueChanged = {},
            hint = "This is the hint",
            isError = false,
            errorMessage = ""
        )
    }
}

@Preview
@Composable
private fun ValuePreview() {
    Surface {
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "This is input",
            onValueChanged = {},
            hint = "",
            isError = false,
            errorMessage = "Error"
        )
    }
}

@Preview
@Composable
private fun ErrorPreview() {
    Surface {
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "",
            onValueChanged = {},
            hint = "This is the hint",
            isError = true,
            errorMessage = "This is the error message"
        )
    }
}