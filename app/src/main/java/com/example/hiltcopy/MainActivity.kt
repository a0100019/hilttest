package com.example.hiltcopy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.hiltcopy.presentation.main.MainNavHost
import com.example.hiltcopy.presentation.main.MainScreen
import com.example.hiltcopy.ui.theme.HiltCopyTheme
import dagger.hilt.android.AndroidEntryPoint

//엔트리 포인트 까먹지 말기
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltCopyTheme {
                    MainNavHost()
            }
        }
    }
}

