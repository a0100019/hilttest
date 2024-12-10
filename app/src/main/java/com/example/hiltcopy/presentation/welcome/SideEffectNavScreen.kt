package com.example.hiltcopy.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltcopy.ui.theme.HiltCopyTheme

@Composable
fun SideEffectNavScreen(
    onNavigateToSelectScreen: () -> Unit
) {
    Surface {
        Column {
            Text("환영합니다")
            Button(
                onClick = {
                    onNavigateToSelectScreen()
                }
            ) {
                Text("SelectScreen으로 이동")
            }
        }
    }
}

@Preview
@Composable
fun SideEffectNavScreenPreview() {
    HiltCopyTheme {
        SideEffectNavScreen(
            onNavigateToSelectScreen = {}
        )
    }
}