package EmailStates

import State

class LookingForAtSignState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            "@" -> PartTwoState()
            " " -> InvalidState()
            else -> this
        }
    }
}