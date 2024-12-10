package com.example.hiltcopy.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hiltcopy.ui.theme.HiltCopyTheme

@Composable
fun SecondScreen() {
    Surface {
        Column {
            Text("두 번째 화면")
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    HiltCopyTheme {
        SecondScreen()
    }
}