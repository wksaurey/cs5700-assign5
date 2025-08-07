package EmailStates

import State

class LookingForPeriodState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            "." -> PartThreeState()
            " ", "@" -> InvalidState()
            else -> this
        }
    }
}