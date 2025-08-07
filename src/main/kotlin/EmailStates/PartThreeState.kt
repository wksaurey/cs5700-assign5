package EmailStates

import State

class PartThreeState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            " ", "@", "." -> InvalidState()
            else -> ValidState()
        }
    }
}