import PasswordStates.LookingForCapitalOrSpecial
import PasswordStates.ValidState

class PasswordDetector: Detector(LookingForCapitalOrSpecial(), ValidState())