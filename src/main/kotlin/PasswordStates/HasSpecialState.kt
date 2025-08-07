package PasswordStates

import SPECIAL_CHARS
import State

class HasSpecialState: State {
    override fun consumeLetter(letter: String): State {
        return if (letter[0].isUpperCase()) ValidState() else this
    }
}