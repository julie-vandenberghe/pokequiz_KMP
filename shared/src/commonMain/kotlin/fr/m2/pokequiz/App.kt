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
import fr.m2.pokequiz.ui.theme.PokeQuizTheme
import fr.m2.pokequiz.resources.*
import org.jetbrains.compose.resources.stringResource
import androidx.compose.foundation.layout.size
import fr.m2.pokequiz.data.FakePokemons
import fr.m2.pokequiz.ui.PokemonImage
@Composable
@Preview
fun App() {
    PokeQuizTheme {
        var gray by remember { mutableStateOf(true) }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            PokemonImage(FakePokemons.pikachu.imageUrl, grayscale = gray, modifier = Modifier.size(240.dp))
            Button(onClick = { gray = !gray }) { Text("Basculer") }
        }
    }
}