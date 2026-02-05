package com.example.kpmlearning.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kpmlearning.models.Mood
import com.example.kpmlearning.viewmodel.MoodViewModel

@Composable
fun MoodScreen(
    viewModel: MoodViewModel = viewModel()
) {
    val mood = viewModel.currentMood

    val animatedColor by animateColorAsState(
        targetValue = mood.color,
        label = "BackgroundColor"
    )

    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = keyframes {
            durationMillis = 300
            1.2f at 150
        },
        label = "EmojiPop"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(animatedColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Emoji + text
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = mood.emoji,
                fontSize = 96.sp,
                modifier = Modifier.scale(scale)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "You are feeling ${mood.label}",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        // Buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MoodButton("😊 Happy") { viewModel.selectMood(Mood.HAPPY) }
            MoodButton("😐 Neutral") { viewModel.selectMood(Mood.NEUTRAL) }
            MoodButton("😴 Tired") { viewModel.selectMood(Mood.TIRED) }
            MoodButton("😡 Angry") { viewModel.selectMood(Mood.ANGRY) }
        }
    }
}

@Composable
fun MoodButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(text)
    }
}

