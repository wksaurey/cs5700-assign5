import EmailStates.PartOneState
import EmailStates.ValidState

class EmailDetector: Detector(PartOneState(), ValidState())