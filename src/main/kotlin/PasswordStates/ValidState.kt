package PasswordStates

import SPECIAL_CHARS
import State

class ValidState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            in SPECIAL_CHARS -> LookingForNonSpecial()
            else -> this
        }
    }
}