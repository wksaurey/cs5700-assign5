package IntStates

import FloatingPointStates.ValidState
import State
import NON_ZERO_DIGITS

class LookingForNonZeroIntState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            in NON_ZERO_DIGITS -> ValidState()
            else -> InvalidState()
        }
    }
}