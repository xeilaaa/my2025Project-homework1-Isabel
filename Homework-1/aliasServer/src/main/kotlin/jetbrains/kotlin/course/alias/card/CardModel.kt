package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

@JvmInline
value class Word(val words: String)


data class Card(
    val id: Identifier,
    val words: List<Word>
)


