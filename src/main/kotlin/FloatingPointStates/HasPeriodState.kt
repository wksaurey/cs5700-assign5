package FloatingPointStates

import State
import DIGITS

class HasPeriodState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            in DIGITS -> ValidState()
            else -> InvalidState()
        }
    }
}