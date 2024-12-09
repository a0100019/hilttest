package com.example.hiltcopy.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltcopy.ui.theme.HiltCopyTheme

@Composable
fun SelectScreen() {

    Surface {
        Column {
            Text("원하는 기능을 선택해주세요")
            Button(
                onClick = { }
            ) {
                Text("계산기")
            }
        }
    }
}

@Preview
@Composable
fun SelectScreenPreview() {
    HiltCopyTheme {
        SelectScreen()
    }
}