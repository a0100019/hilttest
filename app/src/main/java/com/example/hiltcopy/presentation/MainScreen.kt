package com.example.hiltcopy.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hiltcopy.ui.theme.HiltCopyTheme

@Composable
fun MainScreen(
) {
    Surface {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column (
                modifier = Modifier.padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "계산기",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "숫자와 기호를 넣어주세요",
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Column (
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxHeight()
            ){
                Text(
                    text = "첫번 째 숫자",
                    style = MaterialTheme.typography.headlineMedium
                )
                TextField(
                    value = ,
                    onValueChange =
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    HiltCopyTheme {
        MainScreen()
    }
}