package EmailStates

import State

class PartOneState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            " ", "@" -> InvalidState()
            else -> LookingForAtSignState()
        }
    }
}