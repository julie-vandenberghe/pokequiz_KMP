package fr.m2.pokequiz.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp

private val PokedexRed = Color(0xFFDC0A2D)

private val LightColors = lightColorScheme(
    primary = PokedexRed,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDAD6),
    onPrimaryContainer = Color(0xFF410002),
    secondary = Color(0xFF3B4CCA),
    tertiary = Color(0xFFFFCB05),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFB3AE),
    onPrimary = Color(0xFF680010),
    primaryContainer = Color(0xFF93001D),
    onPrimaryContainer = Color(0xFFFFDAD6),
    secondary = Color(0xFFBCC2FF),
    onSecondary = Color(0xFF0D1F8C),
    tertiary = Color(0xFFE9C400),
    onTertiary = Color(0xFF3A3000),
)

object QuizColors {
    val Correct = Color(0xFF2E7D32)
    val Wrong = Color(0xFFC62828)
}

fun typeColor(type: String): Color = when (type) {
    "grass" -> Color(0xFF7AC74C)
    "fire" -> Color(0xFFEE8130)
    "water" -> Color(0xFF6390F0)
    "electric" -> Color(0xFFF7D02C)
    "normal" -> Color(0xFFA8A77A)
    "fairy" -> Color(0xFFD685AD)
    "poison" -> Color(0xFFA33EA1)
    "psychic" -> Color(0xFFF95587)
    else -> Color(0xFF9E9E9E)
}

fun onTypeColor(type: String): Color =
    if (typeColor(type).luminance() > 0.5f) Color.Black else Color.White

@Composable
fun PokeQuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography(),
        shapes = Shapes(medium = RoundedCornerShape(16.dp)),
        content = content,
    )
}