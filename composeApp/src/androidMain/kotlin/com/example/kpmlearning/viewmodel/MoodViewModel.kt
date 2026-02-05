package com.example.kpmlearning.viewmodel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kpmlearning.models.Mood

class MoodViewModel : ViewModel() {

    var currentMood by mutableStateOf(Mood.NEUTRAL)
        private set

    fun selectMood(mood: Mood) {
        currentMood = mood
    }
}
