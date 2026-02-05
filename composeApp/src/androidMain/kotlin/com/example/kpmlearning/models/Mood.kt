package com.example.kpmlearning.models

import androidx.compose.ui.graphics.Color

enum class Mood(
    val emoji: String,
    val label: String,
    val color: Color
) {
    HAPPY("😊", "Happy", Color(0xFFFFF176)),
    NEUTRAL("😐", "Neutral", Color(0xFFBDBDBD)),
    TIRED("😴", "Tired", Color(0xFF90CAF9)),
    ANGRY("😡", "Angry", Color(0xFFEF9A9A))
}
