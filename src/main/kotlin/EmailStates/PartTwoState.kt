package EmailStates

import State

class PartTwoState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            " ", "@", "." -> InvalidState()
            else -> LookingForPeriodState()
        }
    }
}