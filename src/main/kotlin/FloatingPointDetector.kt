import FloatingPointStates.FirstDigitState
import State
import FloatingPointStates.ValidState

class FloatingPointDetector: Detector(FirstDigitState(), ValidState())