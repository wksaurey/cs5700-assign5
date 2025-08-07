import PasswordStates.LookingForCapitalOrSpecialState
import PasswordStates.ValidState

class PasswordDetector: Detector(LookingForCapitalOrSpecialState(), ValidState()) {
    override fun isValid(string: String): Boolean {
        if (string.length < 8) {
            return false
        }
        return super.isValid(string)
    }
}