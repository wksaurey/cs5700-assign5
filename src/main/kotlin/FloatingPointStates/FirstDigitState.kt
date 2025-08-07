package FloatingPointStates

import State
import NON_ZERO_DIGITS

class FirstDigitState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            "0" -> ZeroDigitState()
            "." -> HasPeriodState()
            in NON_ZERO_DIGITS -> HasDigitState()
            else -> InvalidState()
        }
    }
}