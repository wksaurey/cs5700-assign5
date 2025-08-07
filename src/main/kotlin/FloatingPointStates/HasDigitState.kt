package FloatingPointStates

import State
import DIGITS

class HasDigitState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            "." -> HasPeriodState()
            in DIGITS -> this
            else -> InvalidState()
        }
    }
}