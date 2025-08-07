package BinaryStates

import State

class LookingForOne: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            "0" -> this
            "1" -> ValidState()
            else -> InvalidState()
        }
    }
}