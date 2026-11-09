package fr.m2.pokequiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {
    MaterialTheme {
        var count by remember { mutableIntStateOf(0) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFCB05))
                .safeContentPadding()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                16.dp, Alignment.CenterVertically
            ),
        ) {
            Text(
                "Bienvenue dans PokéQuiz",
                style = MaterialTheme.typography.headlineMedium,
            )
            Text(Greeting().greet())
            Button(onClick = { count++ }) {
                Text("Compteur : $count")
            }
        }
    }
}