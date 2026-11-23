package fr.m2.pokequiz.platform

import java.text.Normalizer

private val COMBINING_MARKS = Regex("\\p{Mn}+")

actual fun String.removeDiacritics(): String =
    Normalizer.normalize(this, Normalizer.Form.NFD).replace(COMBINING_MARKS, "")
