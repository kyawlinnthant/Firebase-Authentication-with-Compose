package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    modifier: Modifier,
    inputText: String,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    singleLine: Boolean = true,
    borderShape: Shape = MaterialTheme.shapes.small,
    hint : String,
) {
    OutlinedTextField(
        modifier = modifier,
        value = inputText,
        onValueChange = onValueChanged,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        singleLine = singleLine,
        shape = borderShape,
        placeholder = {
            Text(text = hint)
        }
    )
}

@Preview
@Composable
private fun Preview() {
    Surface {
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            inputText = "",
            onValueChanged = {},
            hint = "Fill text"
        )
    }

}