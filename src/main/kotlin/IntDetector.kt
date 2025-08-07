import State
import IntStates.ValidState

import IntStates.LookingForNonZeroIntState

class IntDetector: Detector(LookingForNonZeroIntState(), ValidState())