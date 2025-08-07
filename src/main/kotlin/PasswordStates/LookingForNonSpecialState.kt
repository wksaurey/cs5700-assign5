package PasswordStates

import SPECIAL_CHARS
import State

class LookingForNonSpecialState: State {
    override fun consumeLetter(letter: String): State {
        return when(letter) {
            in SPECIAL_CHARS -> this
            else -> ValidState()
        }
    }
}