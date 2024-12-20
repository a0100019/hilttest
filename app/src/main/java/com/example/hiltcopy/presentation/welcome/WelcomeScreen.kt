package com.example.hiltcopy.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltcopy.ui.theme.HiltCopyTheme

@Composable
fun WelcomeScreen(
    onNavigateToSideEffectNavScreen: () -> Unit
) {
    Surface {
        Column {
            Text("환영합니다\nSideEffectNavScreen으로 이동하기")
            Button(
                onClick = {
                    onNavigateToSideEffectNavScreen()
                }
            ) {
                Text("이동하기")
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    HiltCopyTheme {
        WelcomeScreen(
            onNavigateToSideEffectNavScreen = {}
        )
    }
}