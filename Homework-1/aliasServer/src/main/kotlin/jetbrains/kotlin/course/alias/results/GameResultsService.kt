package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class GameResultsService(
    private val identifierFactory: IdentifierFactory = IdentifierFactory()
) {
    private val gameResults = mutableListOf<GameResult>()

    fun saveGameResults(result: List<Team>) {
        val gameResultWithId = GameResult(
            id = identifierFactory.uniqueIdentifier(),
            teams = result,
            timestamp = Instant.now().epochSecond
        )
        gameResults.add(gameResultWithId)
    }

    fun getAllGameResults(): List<GameResult> = gameResults
}