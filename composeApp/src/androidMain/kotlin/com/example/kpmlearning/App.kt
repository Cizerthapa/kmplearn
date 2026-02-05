package com.example.kpmlearning

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.kpmlearning.screen.MoodScreen

// This is the main composable function that represents our login screen
@Composable
@Preview
fun App() {
    // MaterialTheme provides consistent styling across the app
    MaterialTheme {
        MoodScreen()
    }
}
