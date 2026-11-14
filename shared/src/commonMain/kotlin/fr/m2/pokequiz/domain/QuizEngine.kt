package fr.m2.pokequiz.domain

import kotlin.time.Duration

class QuizEngine(private val pokemons: List<Pokemon>) {

    init {
        require(pokemons.isNotEmpty()) { "Une partie nécessite au moins un Pokémon" }
    }

    // Explicit backing field (stable en Kotlin 2.4) : List à l'extérieur, MutableList à l'intérieur
    val results: List<QuestionResult>
        field = mutableListOf<QuestionResult>()

    val total: Int get() = pokemons.size
    val currentIndex: Int get() = results.size
    val current: Pokemon? get() = pokemons.getOrNull(currentIndex)
    val isFinished: Boolean get() = currentIndex >= total
    val totalPoints: Int get() = results.sumOf { it.points }
    val totalTime: Duration get() = results.fold(Duration.ZERO) { acc, r -> acc + r.elapsed }

    fun submit(answer: String, hintUsed: Boolean, elapsed: Duration): QuestionResult {
        val pokemon = checkNotNull(current) { "La partie est terminée" }
        val correct = AnswerChecker.isCorrect(answer, pokemon.nameFr)
        val points = ScoreCalculator.points(correct, hintUsed, elapsed)
        val result = QuestionResult(pokemon, answer, correct, hintUsed, elapsed, points)
        results.add(result)
        return result
    }
}
