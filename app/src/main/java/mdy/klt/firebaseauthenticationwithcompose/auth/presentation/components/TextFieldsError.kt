package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VisibilityAnimator(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    errorMessage: String,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(500)) +
                expandVertically(animationSpec = tween(500)),
        exit = fadeOut(animationSpec = tween(500)) +
                shrinkVertically(animationSpec = tween(500))
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp
                ),
            text = errorMessage,
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.error
        )
    }
}