package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4
        val cardsAmount = words.size / WORDS_IN_CARD
    }

    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    private fun generateCards(): List<Card> {
        return words.shuffled()
            .chunked(WORDS_IN_CARD)
            .take(cardsAmount)
            .map { Card(identifierFactory.uniqueIdentifier(), it.toWords()) }
    }

    fun getCardByIndex(index: Int): Card {
        return cards.getOrNull(index) ?: throw IllegalArgumentException("Invalid card index")
    }
}
