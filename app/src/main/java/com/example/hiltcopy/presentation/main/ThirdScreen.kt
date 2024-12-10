package com.example.hiltcopy.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltcopy.ui.theme.HiltCopyTheme

@Composable
fun ThirdScreen() {
    Surface {
        Column {
            Text("세 번째 화면")
        }
    }
}

@Preview
@Composable
fun ThirdScreenPreview() {
    HiltCopyTheme {
        ThirdScreen()
    }
}