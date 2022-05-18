package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    modifier: Modifier,
    inputText: String,
    onValueChanged: (String) -> Unit,
    onValueCleared: () -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    singleLine: Boolean = true,
    borderShape: Shape = RoundedCornerShape(12.dp),
    hint: String,
    isError: Boolean,
    errorMessage: String,
) {
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
            )

            if (inputText.isNotEmpty()) {
                IconButton(onClick = onValueCleared) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Text",
                        tint = MaterialTheme.colors.onSurface.copy(0.5f)

                    )
                }
            }

        }
        VisibilityAnimator(isVisible = isError, errorMessage = errorMessage)
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    Surface {
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "",
            onValueChanged = {},
            onValueCleared = {},
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
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "This is input",
            onValueChanged = {},
            onValueCleared = {},
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
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "",
            onValueChanged = {},
            hint = "This is the hint",
            isError = true,
            onValueCleared = {},
            errorMessage = "This is the error message"
        )
    }
}