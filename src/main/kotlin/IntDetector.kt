import FloatingPointStates.FirstDigitState
import State
import FloatingPointStates.ValidState

import IntStates.LookingForNonZeroIntState

class IntDetector: Detector(LookingForNonZeroIntState(), ValidState())