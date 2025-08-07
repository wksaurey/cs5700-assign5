import BinaryStates.LookingForFirstOneState
import BinaryStates.ValidState

class BinaryDetector: Detector(LookingForFirstOneState(), ValidState())