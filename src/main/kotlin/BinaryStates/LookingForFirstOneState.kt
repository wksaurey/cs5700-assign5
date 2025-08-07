package BinaryStates

import State

class LookingForFirstOneState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            "1" -> ValidState()
            else -> InvalidState()
        }
    }
}