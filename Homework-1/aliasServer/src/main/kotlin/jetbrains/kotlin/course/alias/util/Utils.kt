package jetbrains.kotlin.course.alias.util

// Type alias for Identifier
typealias Identifier = Int

class IdentifierFactory {
    private var counter: Int = 0

    fun uniqueIdentifier(): Identifier {
        return ++counter
    }
}
