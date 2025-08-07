abstract class Detector(private var initialState: State, private var validState: State ) {

    open fun isValid(string: String): Boolean {
        var state = initialState
        for (letter in string) {
            state = state.consumeLetter(letter.toString())
        }
        return state::class == validState::class
    }
}