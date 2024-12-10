package com.example.hiltcopy.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hiltcopy.ui.theme.HiltCopyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainBarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltCopyTheme {
                MainScreen()
            }
        }
    }
}