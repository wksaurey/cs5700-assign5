package FloatingPointStates

import State

class ZeroDigitState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            "." -> HasPeriodState()
            else -> InvalidState()
        }
    }
}