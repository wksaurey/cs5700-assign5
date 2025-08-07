package BinaryStates

import State

class ValidState: State {
    override fun consumeLetter(letter: String): State {
        return when (letter) {
            "1" -> this
            "0" -> LookingForOne()
            else -> InvalidState()
        }
    }
}