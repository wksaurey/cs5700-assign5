package PasswordStates

import SPECIAL_CHARS
import State

class HasCapitalState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            in SPECIAL_CHARS -> LookingForNonSpecialState()
            else -> this
        }
    }
}