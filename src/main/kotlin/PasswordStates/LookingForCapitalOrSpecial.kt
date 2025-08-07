package PasswordStates

import SPECIAL_CHARS
import State

class LookingForCapitalOrSpecial: State {
    override fun consumeLetter(letter: String): State {
        if (letter[0].isUpperCase()) return HasCapitalState()
        else if (letter in SPECIAL_CHARS) return HasSpecialState()
        else return this
    }
}