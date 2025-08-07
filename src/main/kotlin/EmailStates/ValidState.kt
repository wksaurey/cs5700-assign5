package EmailStates

import State

class ValidState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            " ", "@", "." -> InvalidState()
            else -> this
        }
    }
}