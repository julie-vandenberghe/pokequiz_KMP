package fr.m2.pokequiz.data

import fr.m2.pokequiz.domain.Score
import kotlin.time.Duration.Companion.seconds

object FakeScores {
    val initial: List<Score> = listOf(
        Score(id = 1, pseudo = "Sacha", points = 50, totalTime = 71.seconds),
        Score(id = 2, pseudo = "Ondine", points = 45, totalTime = 80.seconds),
        Score(id = 3, pseudo = "Pierre", points = 45, totalTime = 95.seconds),
        Score(id = 4, pseudo = "Jessie", points = 30, totalTime = 120.seconds),
        Score(id = 5, pseudo = "James", points = 20, totalTime = 150.seconds),
    )
}